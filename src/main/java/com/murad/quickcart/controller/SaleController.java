package com.murad.quickcart.controller;

import com.murad.quickcart.dto.MaxSaleDayDTO;
import com.murad.quickcart.dto.TopSellingItemDTO;
import com.murad.quickcart.dto.TopSellingItemLastMonthDTO;
import com.murad.quickcart.exception.ResourceNotFoundException;
import com.murad.quickcart.service.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

    @Autowired
    private SaleService saleService;

    @GetMapping("/total-today")
    public ResponseEntity<Double> getTotalSalesToday() {
        logger.info("Fetching total sales for today");
        Double totalSales = saleService.getTotalSalesToday();
        return ResponseEntity.ok(totalSales);
    }

    @GetMapping("/max-sale-day")
    public ResponseEntity<MaxSaleDayDTO> getMaxSaleDayInRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        logger.info("Fetching max sale day in range: {} to {}", startDate, endDate);
        MaxSaleDayDTO maxSaleDay = saleService.getMaxSaleDayInRange(startDate, endDate);
        return ResponseEntity.ok(maxSaleDay);
    }

    @GetMapping("/top-selling-items")
    public ResponseEntity<List<TopSellingItemDTO>> getTopSellingItems() {
        logger.info("Fetching top selling items");
        List<TopSellingItemDTO> topSellingItems = saleService.getTopSellingItems();
        return ResponseEntity.ok(topSellingItems);
    }

    @GetMapping("/top-selling-items-last-month")
    public ResponseEntity<List<TopSellingItemLastMonthDTO>> getTopSellingItemsInLastMonth() {
        logger.info("Fetching top selling items in last month");
        List<TopSellingItemLastMonthDTO> topSellingItemsLastMonth = saleService.getTopSellingItemsInLastMonth();
        return ResponseEntity.ok(topSellingItemsLastMonth);
    }
}