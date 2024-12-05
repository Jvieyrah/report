package com.betrybe.report.repository;

import com.betrybe.report.entity.Product;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

List<Product> findByExpirationDateBefore(LocalDate date);

List<Product> findByExpirationDateAfter(LocalDate date);

@Query("SELECT p FROM Product p WHERE p.expirationDate BETWEEN :startDate AND :endDate")
List<Product> findByExpirationDateBetween(LocalDate startDate, LocalDate endDate);
}
