package com.example.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePaymentResponse {
    private Long id;
    private String paymentType;
    private Long cost;
}