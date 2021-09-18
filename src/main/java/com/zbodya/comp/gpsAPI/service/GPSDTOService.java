package com.zbodya.comp.gpsAPI.service;

import com.zbodya.comp.gpsAPI.model.GPSDTO;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class GPSDTOService
{
    private Set<GPSDTO> gpsDB = new HashSet<>();

    public void addToGpsDB(GPSDTO gps)
    {
        this.gpsDB.add(gps);
        System.out.println("Device ID: " + gps.getDeviceID() + ", latitude: " + gps.getLatitude() + ", longitude: " + gps.getLongitude());
    }

    public Optional<GPSDTO> getByDeviceID(long deviceID)
    {
        return this.gpsDB.stream().filter(gpsdto -> gpsdto.getDeviceID()==deviceID).findFirst();
    }

    public Set<GPSDTO> getAll()
    {
        return this.gpsDB;
    }

    public boolean validateGPSData(long deviceID, long latitude, long longitude)
    {
        System.out.println("validate");
        return deviceID > 0 && latitude > 0 && longitude > 0;
    }
}
