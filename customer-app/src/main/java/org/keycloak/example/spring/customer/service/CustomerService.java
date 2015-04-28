package org.keycloak.example.spring.customer.service;

import java.util.List;

/**
 * Created by scott on 4/22/15.
 */
public interface CustomerService {

    /**
     * Returns a list of customers.
     */
    List<String> getCustomers();
}
