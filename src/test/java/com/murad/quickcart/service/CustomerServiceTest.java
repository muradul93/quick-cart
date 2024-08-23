package com.murad.quickcart.service;

import com.murad.quickcart.dto.ItemDTO;
import com.murad.quickcart.dto.WishlistDTO;
import com.murad.quickcart.repository.CustomerRepository;
import com.murad.quickcart.repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private CustomerService customerService;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWishlist() {
        WishlistDTO wishlistDTO = new WishlistDTO();
        wishlistDTO.setCustomerId(1L);
        wishlistDTO.setCustomerName("John Doe");
        wishlistDTO.setCustomerEmail("john.doe@example.com");

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemId(1L);
        itemDTO.setItemName("Item 1");
        itemDTO.setItemPrice(100.0);

        wishlistDTO.setItems(Collections.singletonList(itemDTO));

        com.murad.quickcart.model.Customer customer = new com.murad.quickcart.model.Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");

        com.murad.quickcart.model.Item item = new com.murad.quickcart.model.Item();
        item.setId(1L);
        item.setName("Item 1");
        item.setPrice(100.0);

        com.murad.quickcart.model.Wishlist wishlist = new com.murad.quickcart.model.Wishlist();
        wishlist.setCustomer(customer);
        wishlist.setItem(item);

        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));
        when(wishlistRepository.findWishlistWithCustomerAndItemDetails(1L)).thenReturn(Collections.singletonList(wishlist));

        WishlistDTO result = customerService.getWishlist(1L);
        assertEquals(wishlistDTO.getCustomerId(), result.getCustomerId());
        assertEquals(wishlistDTO.getCustomerName(), result.getCustomerName());
        assertEquals(wishlistDTO.getCustomerEmail(), result.getCustomerEmail());
        assertEquals(wishlistDTO.getItems().get(0).getItemId(), result.getItems().get(0).getItemId());
        assertEquals(wishlistDTO.getItems().get(0).getItemName(), result.getItems().get(0).getItemName());
        assertEquals(wishlistDTO.getItems().get(0).getItemPrice(), result.getItems().get(0).getItemPrice());
    }
}