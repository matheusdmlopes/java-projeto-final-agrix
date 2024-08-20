package com.betrybe.agrix.ebytr.staff.service.exception;

/**
 * NotFoundException handler.
 */
public class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}