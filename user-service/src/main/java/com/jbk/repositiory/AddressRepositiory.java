package com.jbk.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbk.entity.Address;

public interface AddressRepositiory extends JpaRepository<Address, Long> {

}
