package com.betrybe.report.controller;

import com.betrybe.report.controller.dto.ProductCreationDto;
import com.betrybe.report.entity.Product;
import com.betrybe.report.service.ProductService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product create(@RequestBody ProductCreationDto dto) {
    return productService.create(dto.toEntity());
  }

  @GetMapping
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{productId}")
  public Product findById(@PathVariable long productId) {
    return productService.findById(productId);
  }

  @PatchMapping("/{productId}")
  public Product update(@PathVariable long productId, @RequestBody ProductCreationDto dto) {
    return productService.update(productId, dto.toEntity());
  }

  @DeleteMapping("/{productId}")
  public void delete(@PathVariable long productId) {
    productService.delete(productId);
  }

  @GetMapping("/expired")
  public List<Product> expiredProducts() {
    return productService.findExpiredProducts();
  }

  @GetMapping("/non-expired")
  public List<Product> nonExpiredProducts() {
    return productService.findNonExpiredProducts();
  }

  @GetMapping("/expires-at")
  public List<Product> expiresAtProducts(@RequestParam LocalDate start, @RequestParam LocalDate end) {
    return productService.findExpiresAtProducts(start, end);
  }

}
