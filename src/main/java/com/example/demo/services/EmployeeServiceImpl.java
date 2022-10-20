package com.example.demo.services;

import com.example.demo.controllers.dtos.request.CreateClientRequest;
import com.example.demo.controllers.dtos.request.CreateEmployeeRequest;
import com.example.demo.controllers.dtos.responses.CreateClientResponse;
import com.example.demo.controllers.dtos.responses.CreateEmployeeResponse;
import com.example.demo.entities.Client;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.IClientRepository;
import com.example.demo.services.interfaces.IClientService;
import com.example.demo.services.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository repository;

    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest request) {
        Employee save = repository.save(from(request));

        return from(save);
    }

    @Override
    public CreateEmployeeResponse get(Long id) {
        Employee employee = findAndEnsureExist(id);
        return from(employee);
    }

    @Override
    public List<CreateEmployeeResponse> list() {
        return repository.findAll().stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public CreateEmployeeResponse update(Long id, CreateEmployeeRequest request) {
        Employee employee = findAndEnsureExist(id);
        employee.setName(request.getName());
        employee.setOcupation(request.getOcupation());
        employee.setAge(request.getAge());
        employee.setTurn(request.getTurn());
        return from(repository.save(employee));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Employee from(CreateEmployeeRequest request){
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setOcupation(request.getOcupation());
        employee.setAge(request.getAge());
        employee.setTurn(request.getTurn());
        return employee;
    }

    private CreateEmployeeResponse from(Employee employee){
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setOcupation(employee.getOcupation());
        response.setAge(employee.getAge());
        response.setTurn(employee.getTurn());
        return response;
    }

    private Employee findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
    
}
