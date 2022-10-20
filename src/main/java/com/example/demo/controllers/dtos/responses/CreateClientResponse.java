package com.example.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateClientResponse {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String curp;
}

