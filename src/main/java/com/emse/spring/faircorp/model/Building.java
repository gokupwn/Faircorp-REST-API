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

    @Column(name = "outsideTemperature")
    private Double outsideTemperature;




}
