package com.inventory.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductIdInfoResponse {

    private int productId;
    private String productName;
    private String productCategory;
    private int available;
    private int currentSP;
    private List<String> change;
}
