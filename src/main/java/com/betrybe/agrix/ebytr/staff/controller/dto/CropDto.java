package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Crop dto.
 */
public record CropDto(Integer id, String name, Double plantedArea,
                      Integer farmId, LocalDate plantedDate, LocalDate harvestDate) {
  /**
   * Crop dto function fromEntity.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarmId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );
  }
}