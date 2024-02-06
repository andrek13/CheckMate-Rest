package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.upjs.CheckMateRest.storage.dao.StationDao;
import sk.upjs.CheckMateRest.storage.triedy.Station;

import java.util.List;

public class StationController {

    private final StationDao stationDao;

    public StationController(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    @GetMapping("/station/getAll")
    public List<Station> getAll(){
        return stationDao.getAll();
    }

    @GetMapping("/station/getStationById/{stationId}")
    public Station getStationById(@PathVariable int stationId){
        return stationDao.getStationById(stationId);
    }

    @PostMapping("/station/createStation/{station}")
    public void createStation(@PathVariable Station station){
        stationDao.createStation(station);
    }

    @DeleteMapping("/station/deleteStation/{stationId}")
    public void deleteStation(@PathVariable int stationId){
        stationDao.deleteStation(stationId);
    }

    @GetMapping("/station/hasShifts/{stationId}")
    public boolean hasShifts(@PathVariable int stationId){
        boolean result = stationDao.hasShifts(stationId);
        return result;
    }
}
