package com.murad.quickcart.service;

import com.murad.quickcart.dto.MaxSaleDayDTO;
import com.murad.quickcart.dto.TopSellingItemDTO;
import com.murad.quickcart.dto.TopSellingItemLastMonthDTO;
import com.murad.quickcart.exception.ResourceNotFoundException;
import com.murad.quickcart.repository.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    private static final Logger logger = LoggerFactory.getLogger(SaleService.class);

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Double getTotalSalesToday() {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusSeconds(1);
        Double totalSales = saleRepository.findTotalSalesByDateTimeRange(startOfDay, endOfDay);
        if (totalSales == null) {
            throw new ResourceNotFoundException("No sales data found for today");
        }
        return totalSales;
    }


    public MaxSaleDayDTO getMaxSaleDayInRange(LocalDate startDate, LocalDate endDate) {
        List<MaxSaleDayDTO> result = saleRepository.findMaxSaleDayInRange(startDate, endDate, PageRequest.of(0, 1));
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("No sales data found for the given date range");
        }
        return result.get(0);
    }

    public List<TopSellingItemDTO> getTopSellingItems() {
        List<TopSellingItemDTO> topSellingItems = saleRepository.findTopSellingItems(PageRequest.of(0, 5));
        if (topSellingItems == null || topSellingItems.isEmpty()) {
            throw new ResourceNotFoundException("No top selling items found");
        }
        return topSellingItems;
    }

    public List<TopSellingItemLastMonthDTO> getTopSellingItemsInLastMonth() {
        LocalDateTime startDate = LocalDateTime.now().minusMonths(1).withDayOfMonth(1).toLocalDate().atStartOfDay();
        LocalDateTime endDate = startDate.plusMonths(1).minusSeconds(1);
        List<TopSellingItemLastMonthDTO> topSellingItemsLastMonth = saleRepository.findTopSellingItemsInLastMonth(startDate, endDate, PageRequest.of(0, 5));
        if (topSellingItemsLastMonth == null || topSellingItemsLastMonth.isEmpty()) {
            throw new ResourceNotFoundException("No top selling items found for the last month");
        }
        return topSellingItemsLastMonth;
    }

}