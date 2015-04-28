package org.keycloak.example.spring.product.web;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;
import org.keycloak.example.spring.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

/**
 * Customer portal controller.
 */
@Controller
@CacheControl(policy = CachePolicy.NO_CACHE)
public class ProductController {

    @Autowired
    private ProductService productService;

    @NotNull
    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleHomePageRequest(Model model) {
        return "home";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String handleCustomersRequest(Principal principal, Model model) {
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("principal",  principal);
        return "products";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String handleAdminRequest(Principal principal, Model model) {
        model.addAttribute("principal",  principal);
        return "admin";
    }

    @ModelAttribute("customerServiceUrl")
    public String populateCustomerServiceUrl() {
        return customerServiceUrl;
    }

    @ModelAttribute("serviceName")
    public String populateServiceName() {
        return "Product Portal";
    }
}
