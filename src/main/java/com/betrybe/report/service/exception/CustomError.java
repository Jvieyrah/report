package com.betrybe.report.service.exception;

public class CustomError extends RuntimeException {

  public CustomError(String message) {
    super(message);
  }
}
