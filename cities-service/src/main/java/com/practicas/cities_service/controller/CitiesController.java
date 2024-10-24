package com.practicas.cities_service.controller;

import com.practicas.cities_service.dto.CityDTO;
import com.practicas.cities_service.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CityService cityService;

    @GetMapping("/hotels")
    public CityDTO getCityAndHotels(@RequestParam String name, @RequestParam String country){
        return cityService.getCitiesHotels(name, country);
    }

}
