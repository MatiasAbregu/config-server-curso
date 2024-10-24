package com.practicas.hotels_service.service;

import com.practicas.hotels_service.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    List<Hotel> hotelsList = new ArrayList<>();

    @Override
    public List<Hotel> getHotelsByCityId(int city_id) {
        List<Hotel> hotelCityList = new ArrayList<>();
        loadHotels();

        for(Hotel h : hotelsList){
            if(h.getCity_id()==city_id){
                hotelCityList.add(h);
            }
        }

        return hotelCityList;
    }

    public void loadHotels(){
        hotelsList.add(new Hotel(1, "Paradise", 5, 1));
        hotelsList.add(new Hotel(2, "Sunset View", 4, 2));
        hotelsList.add(new Hotel(3, "Ocean Breeze", 3, 3));
        hotelsList.add(new Hotel(4, "Mountain Retreat", 4, 1));
        hotelsList.add(new Hotel(5, "City Lights Inn", 3, 2));
        hotelsList.add(new Hotel(6, "Riverside Lodge", 4, 3));
        hotelsList.add(new Hotel(7, "Cozy Cabin Resort", 2, 1));
        hotelsList.add(new Hotel(8, "Luxury Haven", 5, 2));
        hotelsList.add(new Hotel(9, "Historic Grand Hotel", 4, 3));
        hotelsList.add(new Hotel(10, "Tranquil Gardens", 3, 1));
    }
}