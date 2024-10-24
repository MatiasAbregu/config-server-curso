package com.practicas.hotels_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private int id;
    private String name;
    private int stars;
    private int city_id;
}
