package com.haydikodlayalim.shoppingapp.product.repository.mongo;

import com.haydikodlayalim.shoppingapp.product.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
