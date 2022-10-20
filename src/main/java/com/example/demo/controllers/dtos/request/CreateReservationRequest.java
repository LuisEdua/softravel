package com.example.demo.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CreateReservationRequest {
    private Long cost;
    private Date reservationDate;
}
