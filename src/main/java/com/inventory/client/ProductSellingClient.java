package com.inventory.client;

import com.inventory.Model.Request.ProductSellRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${product-service.api.name}" , url = "${product-service.api.ip}")
public interface ProductSellingClient {

    @PostMapping("sell-product")
    ResponseEntity sellProduct(@RequestBody ProductSellRequest productSellRequest);
}
