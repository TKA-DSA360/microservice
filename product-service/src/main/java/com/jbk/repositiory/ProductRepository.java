package com.jbk.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbk.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
