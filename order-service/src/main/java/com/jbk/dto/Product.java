package com.jbk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private long productId;
	private String productName;
	private double productPrice;
	private int productQty;

}
