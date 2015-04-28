package org.keycloak.example.spring.product.service;

import java.util.List;

/**
 * Created by scott on 4/22/15.
 */
public interface ProductService {

    /**
     * Returns a list of products.
     */
    List<String> getProducts();
}
