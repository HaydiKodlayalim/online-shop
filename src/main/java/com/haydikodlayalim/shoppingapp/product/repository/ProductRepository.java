package com.haydikodlayalim.shoppingapp.product.repository;

import com.haydikodlayalim.shoppingapp.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
