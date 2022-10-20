package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreateClientRequest;
import com.example.demo.controllers.dtos.responses.CreateClientResponse;

import java.util.List;

public interface IClientService {
    CreateClientResponse create(CreateClientRequest request);

    CreateClientResponse get(Long id);

    List<CreateClientResponse> list();

    CreateClientResponse update(Long id, CreateClientRequest request);

    void delete(Long id);
}
