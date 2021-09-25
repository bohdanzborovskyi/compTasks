package com.zbodya.comp.gpsAPI.service;

import com.zbodya.comp.gpsAPI.model.GPSDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class GPSDTOService
{
    private Set<GPSDTO> gpsDB = new HashSet<>();

    public void addToGpsDB(GPSDTO gps)
    {
        this.gpsDB.add(gps);
        log.info("Device ID: " + gps.getDeviceID() + ", latitude: " + gps.getLatitude() + ", longitude: " + gps.getLongitude());
    }

    public Optional<GPSDTO> getByDeviceID(long deviceID)
    {
        return this.gpsDB.stream().filter(gpsdto -> gpsdto.getDeviceID()==deviceID).findFirst();
    }

    public Set<GPSDTO> getAll()
    {
        return this.gpsDB;
    }
}
