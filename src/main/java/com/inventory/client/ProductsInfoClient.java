package com.inventory.client;

import com.inventory.Model.Request.ProductInfoRequest;
import com.inventory.Model.Response.PageDataResponse;
import com.inventory.Model.Response.ProductIdInfoResponse;
import com.inventory.Model.Response.ProductStoreData;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${product-service.api.name}" , url = "${product-service.api.ip}")
public interface ProductsInfoClient {

    @PostMapping("update-product")
    ResponseEntity updateProduct(@RequestBody ProductInfoRequest productInfoRequest);

    //Change the response
    @GetMapping("get-product")
    PageDataResponse getproducts(@RequestParam("pageNum") int pageNum , @RequestParam("pageSize") int pageSize);

    @GetMapping("get-productid-info")
    ProductIdInfoResponse getproductinfo(@RequestParam("id") int id);

    @PostMapping("post-productid-info")
    ResponseEntity submitproductinfo(@RequestBody ProductIdInfoResponse productIdInfoResponse );

}
