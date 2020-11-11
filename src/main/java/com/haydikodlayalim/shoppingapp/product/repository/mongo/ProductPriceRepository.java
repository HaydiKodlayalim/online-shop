package com.haydikodlayalim.shoppingapp.product.repository.mongo;

import com.haydikodlayalim.shoppingapp.product.domain.ProductPrice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductPriceRepository extends ReactiveMongoRepository<ProductPrice, String> {
}
