package com.haydikodlayalim.shoppingapp.product.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class ProductDeliveryService {

    public String getDeliveryInfo(String productId) {
        // TODO
        return "Tomorrow";
    }

    public boolean freeDeliveryCheck(String productId, BigDecimal price) {
        // TODO
        return price.compareTo(BigDecimal.ONE) >= 0;
    }
}
