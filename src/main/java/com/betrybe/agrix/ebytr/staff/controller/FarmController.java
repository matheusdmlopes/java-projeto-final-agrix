package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import com.betrybe.agrix.ebytr.staff.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farm controller.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  private final FarmService farmService;
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable Integer id) throws FarmNotFoundException {
    return FarmDto.fromEntity(farmService.findById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return FarmDto.fromEntity(farmService.createFarm(farmCreationDto.toEntity()));
  }

  @GetMapping
  public List<FarmDto> getAllFarms() {
    List<Farm> allFarms = farmService.findAll();
    return allFarms.stream().map(FarmDto::fromEntity).toList();
  }

  /**
   * rota Post.
   *
   * @param id teste
   * @param cropCreationDto teste
   * @return teste
   * @throws FarmNotFoundException teste
   */
  @PostMapping("/{id}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto saveCropToFarm(@PathVariable Integer id, @RequestBody
      CropCreationDto cropCreationDto)
      throws FarmNotFoundException {
    return cropService.setCropFarm(id, cropCreationDto);
  }

  @GetMapping("/{id}/crops")
  public List<CropDto> getCropsFromFarm(@PathVariable Integer id) throws FarmNotFoundException {
    Farm farm = farmService.findById(id);
    return farm.getCrops().stream().map(CropDto::fromEntity).toList();
  }
}