package com.example.demo.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateTicketRequest {
    private String name;
    private String lastName;
    private Short age;
    private String curp;
}
