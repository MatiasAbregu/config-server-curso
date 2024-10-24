package com.practicas.cities_service.service;

import com.practicas.cities_service.dto.CityDTO;
import com.practicas.cities_service.model.City;
import com.practicas.cities_service.repository.HotelsAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private HotelsAPI hotelsAPI;

    List<City> cities = new ArrayList<>();

    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCitiesHotel")
    @Retry(name = "hotels-service")
    public CityDTO getCitiesHotels(String name, String country) {
        City city = findCity(name, country);
        CityDTO cityDTO = new CityDTO(city.getCity_id(), city.getName(), city.getContinent(), city.getCountry(), city.getState(), null);
        cityDTO.setHotelList(hotelsAPI.getHotelsByCityId(city.getCity_id()));
        //createException();
        return cityDTO;
    }

    public City findCity(String name, String country) {
        loadCities();
        for (City c : cities) {
            if (c.getName().equals(name)) {
                if (c.getCountry().equals(country)) {
                    return c;
                }
            }
        }

        return null;
    }

    public CityDTO fallbackGetCitiesHotel(String name, String country, Throwable throwable) {
        System.out.println("Fallback method triggered");
        return new CityDTO(9999999, "Failed", "Failed", "Failed", "Failed", null);
    }

    public void createException() {
        throw new RuntimeException("Prueba Resilience y Circuit Breaker");
    }

    public void loadCities() {
        cities.add(new City(1, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6, "Medellín", "South America", "Colombia", "Antioquía"));
        cities.add(new City(7, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12, "Barcelona", "Europe", "Spain", "Catalunia"));
        cities.add(new City(13, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15, "Valencia", "Europe", "Spain", "Valencian Community"));
    }
}
