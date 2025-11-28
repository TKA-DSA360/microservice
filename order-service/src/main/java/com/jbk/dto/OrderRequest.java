package com.jbk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

	private long userId; // input from end user
	private long productId; // input from end user
	private int quantity; // input from end user

}
