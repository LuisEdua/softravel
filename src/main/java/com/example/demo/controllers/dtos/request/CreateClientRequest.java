package com.example.demo.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateClientRequest {
    private String name;
    private String lastName;
    private Integer age;
    private String curp;
}
