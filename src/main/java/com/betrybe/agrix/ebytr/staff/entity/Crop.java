package com.betrybe.agrix.ebytr.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import org.springframework.cglib.core.Local;

/**
 * Crop entity.
 */
@Entity
@Table(name = "Crop")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private Double plantedArea;
  private Integer farmId;
  private LocalDate plantedDate;
  private LocalDate harvestDate;

  @ManyToOne
  @JoinColumn(name = "farmId", insertable = false, updatable = false)
  private Farm farm;

  @ManyToMany(mappedBy = "crops")
  private List<Fertilizer> fertilizers;

  public Crop() {
  }

  /**
   * Crop constructor.
   */
  public Crop(String name, Double plantedArea, Integer farmId,
      LocalDate plantedDate, LocalDate harvestDate) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.farmId = farmId;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public Integer getFarmId() {
    return farmId;
  }

  public void setFarmId(Integer farmId) {
    this.farmId = farmId;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }
}