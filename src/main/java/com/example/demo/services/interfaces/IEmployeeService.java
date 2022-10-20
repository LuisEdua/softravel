package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreateEmployeeRequest;
import com.example.demo.controllers.dtos.responses.CreateEpmloyeeResponse;

import java.util.List;

public interface IEmployeeService {
    CreateEmployeeResponse create(CreateEmployeeRequest request);

    CreateEmployeeResponse get(Long id);

    List<CreateEmployeeResponse> list();

    CreateEmployeeResponse update(Long id, CreateEmployeeRequest request);

    void delete(Long id);
}
