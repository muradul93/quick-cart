package com.murad.quickcart.repository;

import com.murad.quickcart.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @Query("SELECT w FROM Wishlist w JOIN FETCH w.customer c JOIN FETCH w.item i WHERE w.customer.id = :customerId")
    List<Wishlist> findWishlistWithCustomerAndItemDetails(@Param("customerId") Long customerId);
}