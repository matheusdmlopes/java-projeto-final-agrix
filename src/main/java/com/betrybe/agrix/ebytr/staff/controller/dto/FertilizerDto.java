package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * FertilizerDto.
 *
 * @param id integer
 * @param name string
 * @param brand string
 * @param composition string
 */
public record FertilizerDto(Integer id, String name, String brand, String composition) {

  /**
   * Function from entity.
   *
   * @param fertilizer objectFertilizer
   * @return fertilizerDto
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }
}