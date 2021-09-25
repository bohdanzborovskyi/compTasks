package com.zbodya.comp.gpsAPI.controller;

import com.zbodya.comp.gpsAPI.model.GPSDTO;
import com.zbodya.comp.gpsAPI.service.GPSDTOService;
import com.zbodya.comp.gpsAPI.service.GPSDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("saveGPS")
public class GPSController
{
    private final GPSDTOService gpsdtoService;
    private final GPSDTOValidator gpsdtoValidator;

    @Autowired
    public GPSController(GPSDTOService gpsdtoService,GPSDTOValidator gpsdtoValidator) {
        this.gpsdtoService = gpsdtoService;
        this.gpsdtoValidator = gpsdtoValidator;
    }

    @PostMapping
    ResponseEntity<String> saveGPSData(@RequestParam("deviceID")String deviceID, @RequestParam("latitude")String latitude, @RequestParam("longitude")String longitude)
    {
        if(gpsdtoValidator.validateGPSData(latitude,longitude,deviceID))
        {
            gpsdtoService.addToGpsDB(new GPSDTO(Long.parseLong(deviceID),Long.parseLong(latitude),Long.parseLong(longitude)));
            return new ResponseEntity<>("GPS Data was successfully saved", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("GPS Data invalid", HttpStatus.BAD_REQUEST);

    }
}
