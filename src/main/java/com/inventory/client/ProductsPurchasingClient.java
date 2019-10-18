package com.inventory.client;

import com.inventory.Model.Request.ProductPurchaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${product-service.api.name}" , url = "${product-service.api.ip}")
public interface ProductsPurchasingClient {

    @PostMapping("add-Product")
    ResponseEntity addProduct(ProductPurchaseRequest productPurchaseRequest);
}


