package com.haydikodlayalim.shoppingapp.product.repository.es;

import com.haydikodlayalim.shoppingapp.product.domain.es.ProductEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface ProductEsRepository extends ReactiveElasticsearchRepository<ProductEs, String> {
}
