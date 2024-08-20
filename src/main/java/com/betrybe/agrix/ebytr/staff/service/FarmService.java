package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import com.betrybe.agrix.ebytr.staff.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Farm Service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  public Farm findById(Integer id) throws FarmNotFoundException {
    return farmRepository.findById(id).orElseThrow(FarmNotFoundException::new);
  }

}