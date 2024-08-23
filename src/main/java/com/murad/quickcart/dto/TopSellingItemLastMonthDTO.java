package com.murad.quickcart.dto;

public class TopSellingItemLastMonthDTO {
    private String itemName;
    private Long totalCount;

    public TopSellingItemLastMonthDTO(String itemName, Long totalCount) {
        this.itemName = itemName;
        this.totalCount = totalCount;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}