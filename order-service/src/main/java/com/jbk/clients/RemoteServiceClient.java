package com.jbk.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jbk.dto.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Component
public class RemoteServiceClient {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @CircuitBreaker(name = "userServiceCB", fallbackMethod = "fallbackUserCheck")
    @Retry(name = "userServiceRetry")
    public Boolean checkUserExists(Long userId) {
        return userClient.isUserExists(userId);
    }

    public Boolean fallbackUserCheck(Long userId, Throwable ex) {
        System.out.println("Fallback for USER-SERVICE: " + ex.getMessage());
        return false;
    }

    @CircuitBreaker(name = "productServiceCB", fallbackMethod = "fallbackProductFetch")
    @Retry(name = "productServiceRetry")
    public Product fetchProduct(Long productId) {
        return productClient.getProductById(productId);
    }

    public Product fallbackProductFetch(Long productId, Throwable ex) {
        System.out.println("Fallback for PRODUCT-SERVICE: " + ex.getMessage());
        return null;
    }
}
