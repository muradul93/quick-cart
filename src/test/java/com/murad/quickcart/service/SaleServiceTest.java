package com.murad.quickcart.service;

import com.murad.quickcart.dto.MaxSaleDayDTO;
import com.murad.quickcart.exception.ResourceNotFoundException;
import com.murad.quickcart.repository.SaleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class SaleServiceTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleService saleService;

    public SaleServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMaxSaleDayInRange() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();
        MaxSaleDayDTO maxSaleDay = new MaxSaleDayDTO(startDate, 200.0);

        when(saleRepository.findMaxSaleDayInRange(startDate, endDate, PageRequest.of(0, 1)))
                .thenReturn(Collections.singletonList(maxSaleDay));

        MaxSaleDayDTO result = saleService.getMaxSaleDayInRange(startDate, endDate);
        assertEquals(maxSaleDay, result);
    }

    @Test
    public void testGetMaxSaleDayInRange_NoData() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();

        when(saleRepository.findMaxSaleDayInRange(startDate, endDate, PageRequest.of(0, 1)))
                .thenReturn(Collections.emptyList());

        assertThrows(ResourceNotFoundException.class, () -> saleService.getMaxSaleDayInRange(startDate, endDate));
    }
}