package com.example.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CreateDestinationResponse {
    private Long id;
    private String state;
    private Date checkInTime;
    private Short postalCode;
}