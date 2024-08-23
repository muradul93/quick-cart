package com.murad.quickcart.dto;

import java.time.LocalDate;

public class MaxSaleDayDTO {
    private LocalDate saleDate;
    private Double totalAmount;

    public MaxSaleDayDTO(LocalDate saleDate, Double totalAmount) {
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}