package com.betrybe.report.service.exception;

public class InvalidDateException extends CustomError {

  public InvalidDateException() {
    super("Data inválida!");
  }
}
