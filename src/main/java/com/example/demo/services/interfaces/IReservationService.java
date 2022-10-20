package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreateReservationRequest;
import com.example.demo.controllers.dtos.responses.CreateReservationResponse;

import java.util.List;

public interface IReservationService {
    CreateReservationResponse create(CreateReservationRequest request);

    CreateReservationResponse get(Long id);

    List<CreateReservationResponse> list();

    CreateReservationResponse update(Long id, CreateReservationRequest request);

    void delete(Long id);
}
