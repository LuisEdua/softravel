package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreateTypeOfTripRequest;
import com.example.demo.controllers.dtos.responses.CreateTypeOfTripResponse;

import java.util.List;

public interface ITypeOfTripnService {
    CreateTypeOfTripResponse create(CreateTypeOfTripRequest request);

    CreateTypeOfTripResponse get(Long id);

    List<CreateTypeOfTripResponse> list();

    CreateTicketResponse update(Long id, CreateTypeOfTripRequest request);

    void delete(Long id);
}
