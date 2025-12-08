package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.dto.OrderRequest;
import com.jbk.entity.Orders;
import com.jbk.service.OrderService;

@RestController
@RequestMapping("/orders")
@RefreshScope
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	// place order
	
	@PostMapping("place-order")
	public ResponseEntity<Orders> placeOrder(@RequestBody OrderRequest orderRequest) {
		
		Orders placeOrder = orderService.placeOrder(orderRequest);
		
		return ResponseEntity.ok(placeOrder);
	}

}
