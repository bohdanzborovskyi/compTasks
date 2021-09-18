package com.zbodya.comp.gpsAPI.model;

import lombok.Data;

@Data
public class GPSDTO
{
    private long deviceID;
    private long latitude;
    private long longitude;

    public GPSDTO() {
    }

    public GPSDTO(long deviceID, long latitude, long longitude) {
        this.deviceID = deviceID;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
