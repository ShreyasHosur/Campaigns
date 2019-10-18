package com.inventory.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStoreData {
        private Integer Id;
        private String productCategory;
        private String productName;
        private Integer quantities;
        private Integer currentSP;
}
