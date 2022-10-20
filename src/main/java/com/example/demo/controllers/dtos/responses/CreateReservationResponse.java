package com.example.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
public class CreateReservationResponse {
    private Long id;
    private Long cost;
    private Date reservationDate;
}
