package com.betrybe.report.service.exception;

public class ProductNotFoundException extends NotFoundException{

  public ProductNotFoundException() {
    super("Produto não encontrado!");
  }
}
