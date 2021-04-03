package com.haydikodlayalim.shoppingapp.product.model.product;

import com.haydikodlayalim.shoppingapp.product.model.ProductSellerResponse;
import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetailResponse {
    private String id;
    private List<String> images;
    private String name;
    private String description;
    private ProductSellerResponse seller;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String moneySymbol;
    private String categoryId;
}
