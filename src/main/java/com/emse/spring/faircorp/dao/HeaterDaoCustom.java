package com.emse.spring.faircorp.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface HeaterDaoCustom {

    @Transactional
    @Modifying
    @Query("delete from Heater h where h.room.id = :id")
    void deleteByRoom(@Param("id") Long id);
}
