package com.inventory.Controller;

import com.inventory.Model.Request.Period;
import com.inventory.Model.Response.ExpenseResponse;
import com.inventory.client.DashboardClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DashboardController {

    @Autowired
    private DashboardClient dashboardClient;

    @PostMapping("get-pie-chart-data")
    public ResponseEntity<Map<String,Integer>> getPiechartData(@RequestBody Period period){
        return dashboardClient.getPiechartData(period);
    }

    @PostMapping("get-expense-data")
    public ResponseEntity<ExpenseResponse> getExpense(@RequestBody Period period){
        return dashboardClient.getExpense(period);
    }

}
