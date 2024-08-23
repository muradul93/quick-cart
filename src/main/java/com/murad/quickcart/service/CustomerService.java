package com.murad.quickcart.service;

import com.murad.quickcart.dto.ItemDTO;
import com.murad.quickcart.dto.WishlistDTO;

import com.murad.quickcart.exception.ResourceNotFoundException;
import com.murad.quickcart.model.Wishlist;
import com.murad.quickcart.repository.WishlistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final WishlistRepository wishlistRepository;

    public CustomerService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public WishlistDTO getWishlist(Long customerId) {
        List<Wishlist> wishlists = wishlistRepository.findWishlistWithCustomerAndItemDetails(customerId);
        if (wishlists == null || wishlists.isEmpty()) {
            throw new ResourceNotFoundException("No wishlist found for customer ID: " + customerId);
        }
        return convertToDTO(wishlists);
    }

    private WishlistDTO convertToDTO(List<Wishlist> wishlists) {
        WishlistDTO dto = new WishlistDTO();
        dto.setCustomerId(wishlists.get(0).getCustomer().getId());
        dto.setCustomerName(wishlists.get(0).getCustomer().getName());
        dto.setCustomerEmail(wishlists.get(0).getCustomer().getEmail());
        List<ItemDTO> items = wishlists.stream().map(wishlist -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemId(wishlist.getItem().getId());
            itemDTO.setItemName(wishlist.getItem().getName());
            itemDTO.setItemPrice(wishlist.getItem().getPrice());
            return itemDTO;
        }).collect(Collectors.toList());
        dto.setItems(items);
        return dto;
    }
}