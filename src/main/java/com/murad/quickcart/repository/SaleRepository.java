package com.murad.quickcart.repository;

import com.murad.quickcart.dto.MaxSaleDayDTO;
import com.murad.quickcart.dto.TopSellingItemDTO;
import com.murad.quickcart.dto.TopSellingItemLastMonthDTO;
import com.murad.quickcart.model.Sale;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT SUM(s.amount) FROM Sale s WHERE s.saleDateTime BETWEEN :start AND :end")
    Double findTotalSalesByDateTimeRange(LocalDateTime start, LocalDateTime end);

    @Query("SELECT new com.murad.quickcart.dto.MaxSaleDayDTO(CAST(s.saleDateTime AS LocalDate), SUM(s.amount)) " +
            "FROM Sale s " +
            "WHERE CAST(s.saleDateTime AS LocalDate) BETWEEN :startDate AND :endDate " +
            "GROUP BY CAST(s.saleDateTime AS LocalDate) " +
            "ORDER BY SUM(s.amount) DESC")
    List<MaxSaleDayDTO> findMaxSaleDayInRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

    @Query("SELECT new com.murad.quickcart.dto.TopSellingItemDTO(s.item.name, SUM(s.amount)) FROM Sale s GROUP BY s.item.name ORDER BY SUM(s.amount) DESC")
    List<TopSellingItemDTO> findTopSellingItems(Pageable pageable);

    @Query("SELECT new com.murad.quickcart.dto.TopSellingItemLastMonthDTO(s.item.name, COUNT(s)) FROM Sale s WHERE s.saleDateTime BETWEEN :startDate AND :endDate GROUP BY s.item.name ORDER BY COUNT(s) DESC")
    List<TopSellingItemLastMonthDTO> findTopSellingItemsInLastMonth(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}