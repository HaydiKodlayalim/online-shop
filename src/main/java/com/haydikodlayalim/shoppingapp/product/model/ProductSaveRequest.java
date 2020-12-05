package com.haydikodlayalim.shoppingapp.product.model;

import com.haydikodlayalim.shoppingapp.product.domain.MoneyTypes;
import java.math.BigDecimal;
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
    private BigDecimal price;
    private MoneyTypes money;
    private List<String> images;
    private String sellerId;
    private String categoryId;
}
