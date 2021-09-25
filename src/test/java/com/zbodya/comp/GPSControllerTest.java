package com.zbodya.comp;

import com.zbodya.comp.gpsAPI.controller.GPSController;
import com.zbodya.comp.gpsAPI.service.GPSDTOService;
import com.zbodya.comp.gpsAPI.service.GPSDTOValidator;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GPSController.class)
public class GPSControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GPSDTOValidator gpsdtoValidator;

    @MockBean
    GPSDTOService gpsdtoService;


    @Test
    public void saveGPSData() throws Exception
    {
        when(gpsdtoValidator.validateGPSData(anyString(),anyString(),anyString())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/saveGPS")
                .param("deviceID",String.valueOf(4234423L))
                .param("latitude",String.valueOf(4322L))
                .param("longitude",String.valueOf(34254L)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
