package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * FertilizerCreationDto.
 *
 * @param name string
 * @param brand string
 * @param composition string
 */
public record FertilizerCreationDto(String name, String brand, String composition) {
  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }
}