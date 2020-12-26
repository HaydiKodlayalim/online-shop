package com.haydikodlayalim.shoppingapp.product.model.product;

import com.haydikodlayalim.shoppingapp.product.domain.MoneyTypes;
import com.haydikodlayalim.shoppingapp.product.model.ProductSellerResponse;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String id;
    private String image;
    private String name;
    private String description;
    private ProductSellerResponse seller;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String categoryId;
    private MoneyTypes moneyType;
}
