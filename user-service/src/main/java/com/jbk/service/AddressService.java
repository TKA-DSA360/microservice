package com.jbk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.entity.Address;
import com.jbk.repositiory.AddressRepositiory;

@Service
public class AddressService {

	@Autowired
	private AddressRepositiory addressRepositiory;

	// Add address
	public boolean addAddress(Address address) {

		Address dbAddress = addressRepositiory.save(address);
		if (dbAddress != null) {
			return true;
		}

		return false;

	}

	// Get address by addressId
	public Address getAddressById(long aid) {

		Optional<Address> address = addressRepositiory.findById(aid);

		if (address.isPresent()) {
			return address.get();
		}
		return null;

	}

	public void deleteAddressById(long aid) {

		addressRepositiory.deleteById(aid);

	}

	

	public List<Address> getAllAddresses() {
		List<Address> all = addressRepositiory.findAll();
		return all;
	}

}
