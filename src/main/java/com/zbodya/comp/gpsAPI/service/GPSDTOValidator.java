package com.zbodya.comp.gpsAPI.service;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.*;

@Service
public class GPSDTOValidator
{
    public boolean validateGPSData(String latitude, String longitude,String deviceID)
    {
        return (StringUtils.isNumeric(latitude) && Long.parseLong(latitude)>0) &&
               (StringUtils.isNumeric(longitude) && Long.parseLong(longitude)>0) &&
               (StringUtils.isNumeric(deviceID) && Long.parseLong(deviceID)>0);
    }
}
