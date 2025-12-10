package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.clients.ProductClient;
import com.jbk.clients.RemoteServiceClient;
import com.jbk.clients.UserClient;
import com.jbk.dto.OrderRequest;
import com.jbk.dto.Product;
import com.jbk.entity.Orders;
import com.jbk.repositiory.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class OrderService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;
    
    @Autowired
    private RemoteServiceClient remoteClient;

    @Autowired
    private OrderRepository orderRepository;

   

    // -------------------------
    // PLACE ORDER
    // -------------------------
    public Orders placeOrder(OrderRequest request) {

        Boolean exists = remoteClient.checkUserExists(request.getUserId());
        if (!exists) {
            System.out.println("User NOT found or Service unavailable.");
            return null;
        }

        Product product = remoteClient.fetchProduct(request.getProductId());
        if (product == null) {
            System.out.println("Product NOT found or Service unavailable.");
            return null;
        }

        Orders order = new Orders();
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setOrderDate(java.time.LocalDate.now().toString());
        order.setOrderAmount(product.getProductPrice() * request.getQuantity());

        return orderRepository.save(order);
    }
}
