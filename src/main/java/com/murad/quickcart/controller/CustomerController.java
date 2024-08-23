package com.murad.quickcart.controller;

import com.murad.quickcart.dto.WishlistDTO;
import com.murad.quickcart.model.Wishlist;
import com.murad.quickcart.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{customerId}/wishlist")
    public ResponseEntity<WishlistDTO> getWishlist(@PathVariable Long customerId) {
        logger.info("Fetching wishlist for customer ID: {}", customerId);
        WishlistDTO wishlistDTOS = customerService.getWishlist(customerId);
        return ResponseEntity.ok(wishlistDTOS);
    }
}