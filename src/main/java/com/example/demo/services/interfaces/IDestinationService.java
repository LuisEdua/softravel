package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreateDestinationRequest;
import com.example.demo.controllers.dtos.responses.CreateDestinationResponse;

import java.util.List;

public interface IDestinationService {
    CreateDestinationResponse create(CreateDestinationRequest request);

    CreateDestinationResponse get(Long id);

    List<CreateDestinationResponse> list();

    CreateDestinationResponse update(Long id, CreateDestinationRequest request);

    void delete(Long id);
}
