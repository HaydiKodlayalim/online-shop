package com.haydikodlayalim.shoppingapp.product.startup;

import com.haydikodlayalim.shoppingapp.product.domain.MoneyTypes;
import com.haydikodlayalim.shoppingapp.product.model.category.CategoryResponse;
import com.haydikodlayalim.shoppingapp.product.model.category.CategorySaveRequest;
import com.haydikodlayalim.shoppingapp.product.model.product.ProductSaveRequest;
import com.haydikodlayalim.shoppingapp.product.repository.es.ProductEsRepository;
import com.haydikodlayalim.shoppingapp.product.service.ProductService;
import com.haydikodlayalim.shoppingapp.product.service.category.CategoryService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductService productService;
    private final ProductEsRepository productEsRepository;
    private final CategoryService categoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {

            productEsRepository.deleteAll().block() ;

            CategoryResponse elektronik = categoryService.save(CategorySaveRequest.builder().name("Elektronik").build());
            CategoryResponse telefon = categoryService.save(CategorySaveRequest.builder().name("Cep Telefonu").build());


            IntStream.range(0, 20).forEach(item -> {
                HashMap<MoneyTypes, BigDecimal> price = new HashMap<>() {{
                    put(MoneyTypes.USD, BigDecimal.valueOf((item + 1) * 5));
                    put(MoneyTypes.EUR, BigDecimal.valueOf((item + 1) * 4));
                }};
                productService.save(
                        ProductSaveRequest.builder()
                                .sellerId(randomUUID().toString())
                                .id(randomUUID().toString())
                                .description("Product Description " + item)
                                .price(price)
                                .categoryId(telefon.getId())
                                .name("Product Name " + item)
                                .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                                .images(List.of("https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg"))
                                .build());
            });
        }
    }
}
