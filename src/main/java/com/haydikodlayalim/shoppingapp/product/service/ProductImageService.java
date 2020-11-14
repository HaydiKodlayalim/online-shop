package com.haydikodlayalim.shoppingapp.product.service;

import org.springframework.stereotype.Service;

@Service
public class ProductImageService {

    public String getProductMainImage(String productId) {
        return "https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg";
    }
}
