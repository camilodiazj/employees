package com.tech.exam.exceptions;

public class BusinessException extends ServiceException {

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
