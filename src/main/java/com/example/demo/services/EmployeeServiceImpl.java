package com.example.demo.services;

import com.example.demo.controllers.dtos.request.CreateClientRequest;
import com.example.demo.controllers.dtos.responses.CreateClientResponse;
import com.example.demo.entities.Client;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.IClientRepository;
import com.example.demo.services.interfaces.IClientService;
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
        employee
        return from(repository.save(client));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Client from(CreateClientRequest request){
        Client client = new Client();
        client.setName(request.getName());
        client.setLastname(request.getLastName());
        client.setAge(request.getAge());
        client.setCurp(request.getCurp());
        return client;
    }

    private CreateClientResponse from(Client client){
        CreateClientResponse response = new CreateClientResponse();
        response.setId(client.getId());
        response.setName(client.getName());
        response.setLastName(client.getLastname());
        response.setAge(client.getAge());
        response.setCurp(client.getCurp());
        return response;
    }

    private Client findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
    
}
