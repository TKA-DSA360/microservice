package com.jbk.clients;

import org.springframework.stereotype.Component;

import com.jbk.dto.Product;

@Component
public class ProductClientFallback implements ProductClient {

    @Override
    public Product getProductById(long productId) {
        System.out.println("Product Service DOWN — fallback executed");
        return null;
    }
}
