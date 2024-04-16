package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.exception.CropNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {
  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  @GetMapping
  public List<CropDto> getAllFarms() {
    List<Crop> allCrops = cropService.findAll();
    return allCrops.stream().map(CropDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public CropDto getCropById(@PathVariable Integer id) throws CropNotFoundException {
    return CropDto.fromEntity(cropService.findById(id));
  }

  @GetMapping("/search")
  public List<CropDto> searchCrops(@RequestParam LocalDate start, @RequestParam LocalDate end) {
    return cropService.searchCropsByDate(start, end);
  }
}