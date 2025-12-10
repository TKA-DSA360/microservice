package com.jbk.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jbk.dto.Product;

@FeignClient(
    name = "PRODUCT-SERVICE",
    fallback = ProductClientFallback.class
)
public interface ProductClient {

    @GetMapping("/products/{productId}")
    Product getProductById(@PathVariable long productId);
}
