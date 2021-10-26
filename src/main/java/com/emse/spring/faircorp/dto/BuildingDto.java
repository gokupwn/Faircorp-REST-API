package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;

public class BuildingDto {

    private Long id;
    private Double outsideTemperature;

    public BuildingDto(){

    }

    public BuildingDto(Building building){
        this.id = building.getId();
        this.outsideTemperature = building.getOutsideTemperature();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }
}
