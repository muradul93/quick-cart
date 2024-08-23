package com.murad.quickcart.dto;

public class TopSellingItemDTO {
    private String itemName;
    private Double totalAmount;

    public TopSellingItemDTO(String itemName, Double totalAmount) {
        this.itemName = itemName;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}