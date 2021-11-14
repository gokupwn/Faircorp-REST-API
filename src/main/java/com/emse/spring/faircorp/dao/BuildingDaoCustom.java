package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;


public interface BuildingDaoCustom {
    List<Window> findWindowsByBuilding(Long id);
    List<Heater> findHeatersByBuilding(Long id);
}
