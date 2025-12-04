package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.clients.ProductClient;
import com.jbk.clients.UserClient;
import com.jbk.dto.OrderRequest;
import com.jbk.dto.Product;
import com.jbk.entity.Orders;
import com.jbk.repositiory.OrderRepository;

@Service
public class OrderService {

	@Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

	@Autowired
	private OrderRepository orderRepository;

	// place order

	public Orders placeOrder(OrderRequest orderRequest) {

		// check user is valid or (is existing)
		// call user service (service to service call)

		Boolean isExist =userClient.isUserExists(orderRequest.getUserId());

		if (isExist) {
			System.out.println("User is valid, proceed with order placement");

			// check product is valid or (is existing)
			Product product = productClient.getProductById(orderRequest.getProductId());
			if (product != null) {
				System.out.println("Product is valid, placing order...");

				// place order
				Orders order = new Orders();
				order.setUserId(orderRequest.getUserId());
				order.setProductId(orderRequest.getProductId());
				order.setQuantity(orderRequest.getQuantity());

				String orderDate = java.time.LocalDate.now().toString();
				order.setOrderDate(orderDate);

				double orderAmount = product.getProductPrice() * orderRequest.getQuantity();
				order.setOrderAmount(orderAmount);

				orderRepository.save(order);

				return order;

			} else {
				System.out.println("Product not found");

			}

		} else {
			System.out.println("User not found");
		}
		return null;

	}

	// change order status
	public boolean changeOrderStatus(long orderId, String status) {
		return false;
	}

	// get order by id
	public Orders getOrderById(long orderId) {
		return null;
	}

	// get all orders
	public List<Orders> getAllOrders() {
		return null;
	}

}
