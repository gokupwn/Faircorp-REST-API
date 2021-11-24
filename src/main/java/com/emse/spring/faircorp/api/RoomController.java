package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public RoomController(HeaterDao heaterDao, WindowDao windowDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
//        Room room = null;
//        if (dto.getId() == null) {

        Room room = roomDao.save(new Room(dto.getFloor(), dto.getName(), dto.getCurrentTemperature(), dto.getTargetTemperature()));

//        }
//        else{
//            room = roomDao.getById(dto.getId());
//            room.setTargetTemperature(dto.getTargetTemperature());
//            room.setCurrentTemperature(dto.getCurrentTemperature());
//        }
        return new RoomDto(room);
    }

    /*  Visit This Link
    http://localhost:8081/api/rooms/{roomId}
    */
    @GetMapping(path = "/{roomId}")
    public RoomDto getRoom(@PathVariable("roomId") Long roomId){
        return roomDao.findById(roomId).map(RoomDto::new).orElse(null);
    }

    @GetMapping(path = "/buildings/{buildingId}")
    public List<RoomDto> findRoomsByBuildingId(@PathVariable Long buildingId){
        return roomDao.findRoomsByBuildingId(buildingId).stream().map(RoomDto::new).collect(Collectors.toList());
    }
    
    @DeleteMapping(path = "/{roomId}")
    public void deleteRoom(@PathVariable("roomId") Long roomId){

        /* Delete All Windows */
        windowDao.deleteByRoom(roomId);

        /* Delete All Heaters */
        heaterDao.deleteByRoom(roomId);

        /* Delete The Room*/
        roomDao.deleteById(roomId);
    }

    @PutMapping (path = "/{roomId}/switchWindows")
    public RoomDto switchWindowsStatus(@PathVariable("roomId") Long roomId){
        Room room = roomDao.getById(roomId);
        for (Window window: room.getWindows()) {
            if(window.getWindowStatus() == WindowStatus.OPEN){
                window.setWindowStatus(WindowStatus.CLOSED);
            }

            else{
                window.setWindowStatus(WindowStatus.OPEN);
            }
        }

        return new RoomDto(room);
    }

    @PutMapping(path = "/{roomId}/switchHeaters")
    public RoomDto switchHeatersStatus(@PathVariable("roomId") Long roomId){
        Room room = roomDao.getById(roomId);
        for (Heater heater: room.getHeaters()){
            if(heater.getHeaterStatus() == HeaterStatus.ON){
                heater.setHeaterStatus(HeaterStatus.OFF);
            }
            else {
                heater.setHeaterStatus(HeaterStatus.ON);
            }
        }

        return new RoomDto(room);
    }


}
