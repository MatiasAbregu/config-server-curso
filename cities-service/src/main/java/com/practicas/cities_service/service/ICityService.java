package com.practicas.cities_service.service;

import com.practicas.cities_service.dto.CityDTO;

public interface ICityService {

    public CityDTO getCitiesHotels(String name, String country);

}