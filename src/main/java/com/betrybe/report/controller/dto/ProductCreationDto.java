package com.betrybe.report.controller.dto;

import com.betrybe.report.entity.Product;
import java.time.LocalDate;

public record ProductCreationDto(String name, LocalDate manufactureDate, LocalDate expirationDate) {

  public Product toEntity() {
    Product product = new Product();
    product.setName(name);
    product.setManufactureDate(manufactureDate);
    product.setExpirationDate(expirationDate);
    return product;
  }
}
