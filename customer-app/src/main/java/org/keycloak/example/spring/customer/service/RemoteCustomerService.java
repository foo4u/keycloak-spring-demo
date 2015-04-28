package org.keycloak.example.spring.customer.service;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates making a call to
 */
@Service
public class RemoteCustomerService implements CustomerService {

    @Autowired
    private KeycloakRestTemplate template;

    @NotNull
    @Value("${database.service.url}")
    private String endpoint;

    @Override
    public List<String> getCustomers() {
        ResponseEntity<String[]> response = template.getForEntity(endpoint, String[].class);
        return Arrays.asList(response.getBody());
    }
}
