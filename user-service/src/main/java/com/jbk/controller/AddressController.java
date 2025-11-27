package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Address;
import com.jbk.service.AddressService;

@RestController
@RequestMapping("/user/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	// Add address : localhost:8080/user/address/add-address
	
	
	
	@PostMapping("/add-address")
	public ResponseEntity<Boolean> addAddress(@RequestBody Address address) {

		boolean isAdded = addressService.addAddress(address);

		if (isAdded) {
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
		}

	}

	// Get address by addressId
	@GetMapping("/get-address/{aid}")
	// localhost:8080/user/address/get-address/1
	public ResponseEntity<Address> getAddressById(@PathVariable long aid) {

		Address address = addressService.getAddressById(aid);

		if (address != null) {
			return new ResponseEntity<Address>(address, HttpStatus.OK);
		} else {
			return new ResponseEntity<Address>(address, HttpStatus.NO_CONTENT);
		}

	}

	// Delete address by addressId
	@DeleteMapping("/delete-address/{aid}")
	public void deleteAddressById(@PathVariable long aid) {

		addressService.deleteAddressById(aid);

	}

	// Get all addresses
	@GetMapping("/get-all-addresses")
	// localhost:8080/user/address/get-all-addresses
	public ResponseEntity<List<Address>> getAllAddresses() {

		List<Address> addresses = addressService.getAllAddresses();

		if (addresses.size() > 0) {
			return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Address>>(addresses, HttpStatus.NO_CONTENT);
		}

	}

}
