package com.example.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateTypeOfTripResponse {
    private Long id;
    private String typeOfTrip;
    private String typeClass;
}
