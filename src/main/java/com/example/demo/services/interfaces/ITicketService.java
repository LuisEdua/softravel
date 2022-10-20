package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreateTicketRequest;
import com.example.demo.controllers.dtos.responses.CreateTicketResponse;

import java.util.List;

public interface ITicketService {
    CreateTicketResponse create(CreateTicketRequest request);

    CreateTicketResponse get(Long id);

    List<CreateTicketResponse> list();

    CreateTicketResponse update(Long id, CreateTicketRequest request);

    void delete(Long id);
}
