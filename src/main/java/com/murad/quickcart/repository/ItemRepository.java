package com.murad.quickcart.repository;

import com.murad.quickcart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}