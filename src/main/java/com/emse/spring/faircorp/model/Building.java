package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Building")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;


    private Double outsideTemperature;

    public Building(){

    }

    public Building (Double outsideTemperature){
        this.outsideTemperature = outsideTemperature;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
