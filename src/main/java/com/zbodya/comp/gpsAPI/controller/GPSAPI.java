package com.zbodya.comp.gpsAPI.controller;

import com.zbodya.comp.gpsAPI.model.GPSDTO;
import com.zbodya.comp.gpsAPI.service.GPSDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gpsAPI/")
public class GPSAPI
{

    @Autowired
    GPSDTOService gpsdtoService;

    @PostMapping("/saveGPS")
    ResponseEntity<String> saveGPSData(@RequestParam("deviceID")String deviceID, @RequestParam("latitude")String latitude, @RequestParam("longitude")String longitude)
    {
        System.out.println("GPS API");
        long devID = Long.parseLong(deviceID);
        long lati = Long.parseLong(latitude);
        long longi = Long.parseLong(longitude);
        if(gpsdtoService.validateGPSData(devID,lati,longi))
        {
            gpsdtoService.addToGpsDB(new GPSDTO(devID, lati, longi));
            return new ResponseEntity<>("GPS Data was successfully saved", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("GPS Data invalid", HttpStatus.BAD_REQUEST);

    }
}
