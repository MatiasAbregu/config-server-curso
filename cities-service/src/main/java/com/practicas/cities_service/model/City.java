package com.practicas.cities_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int city_id;
    private String name;
    private String continent;
    private String country;
    private String state;
}
