package com.inventory.client;

import com.inventory.Model.Request.Period;
import com.inventory.Model.Response.ExpenseResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "${product-service.api.name}" , url = "${product-service.api.ip}")
public interface DashboardClient {

    @PostMapping("get-pie-chart-data")
    public ResponseEntity<Map<String,Integer>> getPiechartData(@RequestBody Period period);

    @PostMapping("get-expense-data")
    public ResponseEntity<ExpenseResponse> getExpense(@RequestBody Period period);
}







