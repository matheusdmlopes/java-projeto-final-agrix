package com.betrybe.agrix.ebytr.staff.service.exception;

/**
 * FarmNotFoundException handler.
 */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}