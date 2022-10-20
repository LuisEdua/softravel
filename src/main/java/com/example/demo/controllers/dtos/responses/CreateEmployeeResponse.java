package com.example.demo.controllers.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEmployeeResponse {

    private Long id;
    private String name;
    private String ocupation;
    private Short age;
    private String turn;

}
