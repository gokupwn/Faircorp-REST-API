package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/buildings")
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;
    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao, HeaterDao heaterDao, WindowDao windowDao){
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto buildingDto){

        Building building = buildingDao.save( new Building(buildingDto.getOutsideTemperature()));
        return new BuildingDto(building);
    }

    @GetMapping("/{buildingId}")
    public BuildingDto getBuilding(@PathVariable("buildingId") Long buildingId){
        return buildingDao.findById(buildingId).map(BuildingDto::new).orElse(null);
    }

    @DeleteMapping("/{buildingId}")
    public void deleteBulding(@PathVariable("buildingId") Long buildingId){

        Building building = buildingDao.getById(buildingId);
        for (Room room: building.getRooms()) {
            windowDao.deleteByRoom(room.getId());
            heaterDao.deleteByRoom(room.getId());
        }
        roomDao.deleteByBuilding(buildingId);
        buildingDao.deleteById(buildingId);
    }

}
