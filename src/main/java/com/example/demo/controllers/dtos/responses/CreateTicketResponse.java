package com.example.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateTicketResponse {
    private Long id;
    private String name;
    private String lastName;
    private Short age;
    private String curp;
}

