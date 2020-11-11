package com.haydikodlayalim.shoppingapp.product.service;

import com.haydikodlayalim.shoppingapp.product.model.ProductResponse;
import com.haydikodlayalim.shoppingapp.product.model.ProductSaveRequest;
import com.haydikodlayalim.shoppingapp.product.repository.mongo.ProductRepository;
import com.haydikodlayalim.shoppingapp.repository.es.ProductEsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;

    List<ProductResponse> getByPaging(Pageable pageable) {
        // 1 - ES den sorgula
        // 2 - Calc fieldlari isle
        // 3 - redisten ihtiyac alanlarini getir
        // 4 - response nesnesine donustur
        return null;
    }

    ProductResponse save(ProductSaveRequest productSaveRequest) {
        // 1 - mongoya yaz
        // 2 - ES guncelle
        // 3 - Redis guncelle
        // 4 - Es den cevap don
        // 5 - response nesnesine donustur
        return null;
    }
}
