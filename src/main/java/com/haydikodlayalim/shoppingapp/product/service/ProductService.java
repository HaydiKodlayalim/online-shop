package com.haydikodlayalim.shoppingapp.product.service;

import com.haydikodlayalim.shoppingapp.product.domain.MoneyTypes;
import com.haydikodlayalim.shoppingapp.product.domain.Product;
import com.haydikodlayalim.shoppingapp.product.domain.ProductImage;
import com.haydikodlayalim.shoppingapp.product.domain.es.ProductEs;
import com.haydikodlayalim.shoppingapp.product.model.product.ProductResponse;
import com.haydikodlayalim.shoppingapp.product.model.product.ProductSaveRequest;
import com.haydikodlayalim.shoppingapp.product.model.ProductSellerResponse;
import com.haydikodlayalim.shoppingapp.product.repository.mongo.ProductRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.haydikodlayalim.shoppingapp.product.domain.ProductImage.ImageType.FEATURE;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;
    private final ProductEsService productEsService;

    public Flux<ProductResponse> getAll() {
        return productEsService.findAll().map(this::mapToDto);
    }

    public ProductResponse save(ProductSaveRequest request) {
        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("PR0001")
                .categoryId(request.getCategoryId())
                .companyId(request.getSellerId())
                .description(request.getDescription())
                .features(request.getFeatures())
                .name(request.getName())
                .productImage(request.getImages().stream().map(it -> new ProductImage(FEATURE, it)).collect(toList()))
                .build();
        product = productRepository.save(product).block();
        // 3 - Redis guncelle
        return this.mapToDto(productEsService.saveNewProduct(product).block());
    }

    /**
     * 2 - Calc fieldlari isle
     * 3 - redisten ihtiyac alanlarini getir
     * 4 - response nesnesine donustur
     *
     * @return
     */
    private ProductResponse mapToDto(ProductEs item) {
        if (item == null) {
            return null;
        }

        BigDecimal productPrice = productPriceService.getByMoneyType(item.getId(), MoneyTypes.USD);
        return ProductResponse.builder()
                .price(productPrice)
                .name(item.getName())
                .features(item.getFeatures())
                .id(item.getId())
                .description(item.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(item.getId()))
                .categoryId(item.getCategory().getId())
                .available(productAmountService.getByProductId(item.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(item.getId(), productPrice))
                .moneyType(MoneyTypes.USD)
                .image(productImageService.getProductMainImage(item.getId()))
                .seller(ProductSellerResponse.builder().id(item.getSeller().getId()).name(item.getSeller().getName()).build())
                .build();
    }

    public Mono<Long> count() {
        return productRepository.count();
    }
}
