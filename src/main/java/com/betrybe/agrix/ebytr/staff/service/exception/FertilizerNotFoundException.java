package com.betrybe.agrix.ebytr.staff.service.exception;

/**
 * FertilizerNotFoundException.
 */
public class FertilizerNotFoundException extends NotFoundException {
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}