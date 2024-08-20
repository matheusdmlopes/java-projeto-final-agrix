package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * CropCreationDto.
 */
public record CropCreationDto(String name, Double plantedArea,
                              Integer farmId, LocalDate plantedDate, LocalDate harvestDate) {
  /**
   * Crop creationDto function toEntity.
   */
  public Crop toEntity() {
    return new Crop(name, plantedArea, farmId, plantedDate, harvestDate);
  }
}