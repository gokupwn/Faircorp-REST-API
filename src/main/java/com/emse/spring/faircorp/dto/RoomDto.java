package com.emse.spring.faircorp.dto;


import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.HashSet;
import java.util.Set;

public class RoomDto {

    private Long id;
    private int floor;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;
//    private Set<Long> heatersIds = new HashSet<Long>();
//    private Set<Long> windowsIds = new HashSet<Long>();

    public RoomDto() {
    }

    public RoomDto (Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

//    public Set<Long> getHeatersIds() {
//        return heatersIds;
//    }
//
//    public void setHeatersIds(Set<Long> heatersIds) {
//        this.heatersIds = heatersIds;
//    }

//    public Set<Long> getWindowsIds() {
//        return windowsIds;
//    }
//
//    public void setWindowsIds(Set<Long> windowsIds) {
//        this.windowsIds = windowsIds;
//    }
}
