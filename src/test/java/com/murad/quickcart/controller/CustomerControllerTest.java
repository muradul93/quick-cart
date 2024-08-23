package com.murad.quickcart.controller;

import com.murad.quickcart.dto.ItemDTO;
import com.murad.quickcart.dto.WishlistDTO;
import com.murad.quickcart.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testGetWishlist() throws Exception {
        WishlistDTO wishlistDTO = new WishlistDTO();
        wishlistDTO.setCustomerId(1L);
        wishlistDTO.setCustomerName("John Doe");
        wishlistDTO.setCustomerEmail("john.doe@example.com");

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemId(1L);
        itemDTO.setItemName("Item 1");
        itemDTO.setItemPrice(100.0);

        wishlistDTO.setItems(Collections.singletonList(itemDTO));

        when(customerService.getWishlist(1L)).thenReturn(wishlistDTO);

        mockMvc.perform(get("/api/v1/customers/1/wishlist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(1L))
                .andExpect(jsonPath("$.customerName").value("John Doe"))
                .andExpect(jsonPath("$.customerEmail").value("john.doe@example.com"))
                .andExpect(jsonPath("$.items[0].itemId").value(1L))
                .andExpect(jsonPath("$.items[0].itemName").value("Item 1"))
                .andExpect(jsonPath("$.items[0].itemPrice").value(100.0));
    }
}