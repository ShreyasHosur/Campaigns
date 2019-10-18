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
public class PageDataResponse {
    private List<ProductStoreData> productStoreData;
    private int totalPages;
    private int size;
}

