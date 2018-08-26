package com.upch.microservices.dto;

import java.util.List;
import lombok.Data;

@Data
public class StateWithCitiesDTO {
    
    private Long id;
    private String name;
    private String description;
    
    private List<CityDTO> cities;
    
}
