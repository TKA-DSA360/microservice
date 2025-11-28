package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;  // auto generated
	
	private long userId; // input from end user
	private long productId; // input from end user
	private int quantity; // input from end user
	private String orderDate;  // auto captured
	private double orderAmount; // as per product price and quantity
	
	private String orderStatus="PLACED"; // Placed, Shipped, Delivered, Cancelled
	
	
	

}
