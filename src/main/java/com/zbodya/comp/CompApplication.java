package com.zbodya.comp;

import com.zbodya.comp.trees.Service.TreeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompApplication
{


    public static void main(String[] args)
    {
        SpringApplication.run(CompApplication.class, args);
        TreeService.loadTreeData();
    }



}
