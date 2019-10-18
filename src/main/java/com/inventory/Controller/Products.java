package com.inventory.Controller;

import com.inventory.Model.Request.ProductInfoRequest;
import com.inventory.Model.Request.ProductPurchaseRequest;
import com.inventory.Model.Request.ProductSellRequest;
import com.inventory.Model.Response.PageDataResponse;
import com.inventory.Model.Response.ProductIdInfoResponse;
import com.inventory.client.ProductSellingClient;
import com.inventory.client.ProductsInfoClient;
import com.inventory.client.ProductsPurchasingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Products {

    @Autowired
    private ProductSellingClient productSellingClient;

    @Autowired
    private ProductsInfoClient productsInfoClient;

    @Autowired
    private ProductsPurchasingClient productsPurchasingClient;

    @PostMapping("sell-product")
    public ResponseEntity sellProduct(@RequestBody ProductSellRequest productSellRequest){
        return ResponseEntity.ok(productSellingClient.sellProduct(productSellRequest));
    }

    @PostMapping("update-product")
    public ResponseEntity updateProduct(@RequestBody ProductInfoRequest productInfoRequest){
        return ResponseEntity.ok(productsInfoClient.updateProduct(productInfoRequest));
    }

    @GetMapping("get-product")
    public PageDataResponse getproducts(@RequestParam("pageNum") int pageNum , @RequestParam("pageSize") int pageSize){
        return productsInfoClient.getproducts(pageNum,pageSize);
    }

    @GetMapping("get-productid-info")
    public ProductIdInfoResponse getproductinfo(@RequestParam("id") int id){
       return productsInfoClient.getproductinfo(id);
    }

    @PostMapping("post-productid-info")
    ResponseEntity submitproductinfo(@RequestBody ProductIdInfoResponse productIdInfoResponse ){
        return ResponseEntity.ok(productsInfoClient.submitproductinfo(productIdInfoResponse));
    }

    @PostMapping("add-Product")
    ResponseEntity addProduct(ProductPurchaseRequest productPurchaseRequest){
        return ResponseEntity.ok(productsPurchasingClient.addProduct(productPurchaseRequest));
    }
}
