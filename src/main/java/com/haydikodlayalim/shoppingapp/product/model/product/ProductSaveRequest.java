package com.haydikodlayalim.shoppingapp.product.model.product;

import com.haydikodlayalim.shoppingapp.product.domain.MoneyTypes;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductSaveRequest {
    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available;
    private HashMap<MoneyTypes, BigDecimal> price;
    private List<String> images;
    private String sellerId;
    private String categoryId;
}
