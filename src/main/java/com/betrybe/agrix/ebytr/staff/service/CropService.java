package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import com.betrybe.agrix.ebytr.staff.service.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exception.FarmNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CropService.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FarmRepository farmRepository;

  /**
   * CropService.
   *
   * @param cropRepository teste
   * @param farmService teste
   * @param farmRepository teste
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmService farmService,
      FarmRepository farmRepository) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.farmRepository = farmRepository;
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop createCrop(Crop crop) {
    return cropRepository.save(crop);
  }

  public Crop findById(Integer id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  /**
   * testando.
   *
   * @param farmId teste
   * @param cropDto teste
   * @return teste
   * @throws FarmNotFoundException teste
   */
  public CropDto setCropFarm(Integer farmId, CropCreationDto cropDto) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);

    Crop newCrop = cropDto.toEntity();
    newCrop.setFarmId(farmId);

    farmRepository.save(farm);
    cropRepository.save(newCrop);

    return CropDto.fromEntity(newCrop);
  }

  /**
   * method to search crops by date.
   *
   * @param start start date
   * @param end end date
   * @return crop list between both dates
   */
  public List<CropDto> searchCropsByDate(LocalDate start, LocalDate end) {
    List<Crop> getAllCrops = findAll();
    return getAllCrops.stream().filter(crop -> crop.getHarvestDate().isBefore(end)
        && crop.getHarvestDate().isAfter(start)).map(CropDto::fromEntity).toList();
  }
}