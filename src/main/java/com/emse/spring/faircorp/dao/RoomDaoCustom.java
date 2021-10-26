package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RoomDaoCustom {
    Room findByName(String name);

    @Transactional
    @Modifying
    @Query("delete from Room r where r.building.id = :id")
    void deleteByBuilding(@Param("id") Long id);
}
