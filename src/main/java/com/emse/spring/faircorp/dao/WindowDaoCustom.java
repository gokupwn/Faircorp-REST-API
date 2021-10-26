package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface WindowDaoCustom {
    List <Window> findRoomOpenWindows(Long id);
    /*
    * To Delete All Windows On A Specific Room
    * With Room ID `id`
    *
    */
    @Transactional
    @Modifying
    @Query ("delete from Window w where w.room.id = :id")
    void deleteByRoom(@Param("id") Long id);
}
