package com.haydikodlayalim.shoppingapp.product.domain;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

    private String id;
    private String name;
    private String code;
    private String description;
    private String companyId;
    private String features;
    private String categoryId;
    private List<ProductImage> productImage;
    private Boolean active;

    /*

    {  document - ES
            'id'
            'image': 'https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg', sub-document
            'name':
            'description':
            'seller': - document - ES
            'features': html document - ES
            'available': kalan adet, - redis and document
            'freeDelivery': false, - Service / if price > 50
            'deliveryIn': 'Tomorrow', - calc util
            'price':550,
            'category' - document
            'money':'$' - enum ()
    }

    */
}
