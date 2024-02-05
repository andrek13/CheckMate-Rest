package sk.upjs.CheckMateRest.storage.dao;


import sk.upjs.CheckMateRest.storage.triedy.Station;

import java.util.List;


public interface StationDao {
    List<Station> getAll();

    Station getStationById(int stationId);

    void createStation(Station station);

    void deleteStation(int stationId);

    boolean hasShifts(int stationId);
}
