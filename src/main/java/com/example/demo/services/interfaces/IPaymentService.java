package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreatePaymentRequest;
import com.example.demo.controllers.dtos.responses.CreatePaymentResponse;

import java.util.List;

public interface IPaymentService {
    CreatePaymentResponse create(CreatePaymentRequest request);

    CreatePaymentResponse get(Long id);

    List<CreatePaymentResponse> list();

    CreatePaymentResponse update(Long id, CreatePaymentRequest request);

    void delete(Long id);
}
