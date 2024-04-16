package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * FarmCreationDto, instantiates a new instance of entity Farm.
 */
public record FarmCreationDto(String name, Double size) {
  public Farm toEntity() {
    return new Farm(name, size);
  }
}