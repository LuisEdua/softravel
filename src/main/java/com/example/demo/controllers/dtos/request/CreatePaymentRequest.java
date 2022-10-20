package com.example.demo.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePaymentRequest {
    private String paymentType;
    private Long cost;
}
