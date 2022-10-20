package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.request.CreateEmployeeRequest;
import com.example.demo.controllers.dtos.responses.CreateEmployeeResponse;

import java.util.List;

<<<<<<< HEAD
public interface IEpmloyeeService {
=======
public interface IEmployeeService {
>>>>>>> 26fe7952684a3546ceee443eb85b024c6ab9956a
    CreateEmployeeResponse create(CreateEmployeeRequest request);
    CreateEmployeeResponse get(Long id);

    List<CreateEmployeeResponse> list();

    CreateEmployeeResponse update(Long id, CreateEmployeeRequest request);

    void delete(Long id);
}
