package com.jbk.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbk.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
