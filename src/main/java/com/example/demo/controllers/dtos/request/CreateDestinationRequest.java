package com.example.demo.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CreateDestinationRequest {
    private String state;
    private Date checkInTime;
    private Short postalCode;
}
