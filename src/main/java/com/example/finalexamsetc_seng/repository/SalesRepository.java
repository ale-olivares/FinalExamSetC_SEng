package com.example.finalexamsetc_seng.repository;

import com.example.finalexamsetc_seng.entities.sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalesRepository  extends JpaRepository<sales, Long> {

    @Query("SELECT COALESCE(SUM(s.qty), 0) FROM sales s WHERE s.icode = :icode")
    Double getTotalSalesForCategory(String icode);

    sales findSaleById(Long id);
}
