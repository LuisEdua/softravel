package com.example.demo.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEmployeeRequest {
    private String name;
    private String ocupation;
    private Short age;
    private String turn;
}
