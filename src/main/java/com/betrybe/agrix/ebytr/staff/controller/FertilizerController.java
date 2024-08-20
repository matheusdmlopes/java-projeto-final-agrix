package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import com.betrybe.agrix.ebytr.staff.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fertilizer Controller.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {
  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFertilizer(@RequestBody FertilizerCreationDto fertilizerCreationDto) {
    return FertilizerDto
        .fromEntity(fertilizerService.createFertilizer(fertilizerCreationDto.toEntity()));
  }

  @GetMapping
  @Secured("ROLE_ADMIN")
  public List<FertilizerDto> findAllFertilizers() {
    List<Fertilizer> fertilizers = fertilizerService.findAllFertilizers();
    return fertilizers.stream().map(FertilizerDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public FertilizerDto findFertilizerById(@PathVariable Integer id)
      throws FertilizerNotFoundException {
    return FertilizerDto.fromEntity(fertilizerService.findFertilizerById(id));
  }
}