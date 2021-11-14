package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomDaoCustomImpl implements RoomDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomsByBuildingId(Long id){
        String jpql = "select r FROM Room r where r.building.id =:id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public Room findByName(String name){
        String jpql = "select r from Room r where r.name =: name";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public  void deleteByBuilding(Long id){
    }
}
