package com.murad.quickcart.controller;

import com.murad.quickcart.dto.MaxSaleDayDTO;
import com.murad.quickcart.dto.TopSellingItemDTO;
import com.murad.quickcart.dto.TopSellingItemLastMonthDTO;
import com.murad.quickcart.service.SaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(SaleController.class)
public class SaleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaleService saleService;

    @Test
    public void testGetTotalSalesToday() throws Exception {
        when(saleService.getTotalSalesToday()).thenReturn(100.0);

        mockMvc.perform(get("/api/v1/sales/total-today"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(100.0));
    }

    @Test
    public void testGetMaxSaleDayInRange() throws Exception {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();
        MaxSaleDayDTO maxSaleDay = new MaxSaleDayDTO(startDate, 200.0);

        when(saleService.getMaxSaleDayInRange(startDate, endDate)).thenReturn(maxSaleDay);

        mockMvc.perform(get("/api/v1/sales/max-sale-day")
                        .param("startDate", startDate.toString())
                        .param("endDate", endDate.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.saleDate").value(startDate.toString()))
                .andExpect(jsonPath("$.totalAmount").value(200.0));
    }

    @Test
    public void testGetTopSellingItems() throws Exception {
        List<TopSellingItemDTO> topSellingItems = Collections.singletonList(new TopSellingItemDTO("Item1", 300.0));

        when(saleService.getTopSellingItems()).thenReturn(topSellingItems);

        mockMvc.perform(get("/api/v1/sales/top-selling-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].itemName").value("Item1"))
                .andExpect(jsonPath("$[0].totalAmount").value(300.0));
    }

    @Test
    public void testGetTopSellingItemsInLastMonth() throws Exception {
        List<TopSellingItemLastMonthDTO> topSellingItemsLastMonth = Collections.singletonList(new TopSellingItemLastMonthDTO("Item2", 50L));

        when(saleService.getTopSellingItemsInLastMonth()).thenReturn(topSellingItemsLastMonth);

        mockMvc.perform(get("/api/v1/sales/top-selling-items-last-month"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].itemName").value("Item2"))
                .andExpect(jsonPath("$[0].totalCount").value(50L));
    }
}