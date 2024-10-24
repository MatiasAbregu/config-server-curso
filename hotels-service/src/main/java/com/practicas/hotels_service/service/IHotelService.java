package com.practicas.hotels_service.service;

import com.practicas.hotels_service.model.Hotel;

import java.util.List;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId(int city_id);

}