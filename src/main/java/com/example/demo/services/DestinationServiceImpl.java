package com.example.demo.services;

import com.example.demo.controllers.dtos.request.CreateClientRequest;
import com.example.demo.controllers.dtos.responses.CreateClientResponse;
import com.example.demo.entities.Client;
import com.example.demo.repositories.IClientRepository;
import com.example.demo.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientRepository repository;


    @Override
    public CreateClientResponse create(CreateClientRequest request) {
        Client save = repository.save(from(request));

        return from(save);
    }

    @Override
    public CreateClientResponse get(Long id) {
        Client client = findAndEnsureExist(id);
        return from(client);
    }

    @Override
    public List<CreateClientResponse> list() {
        return repository.findAll().stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public CreateClientResponse update(Long id, CreateClientRequest request) {
        Client client = findAndEnsureExist(id);
        client.setName(request.getName());
        return from(repository.save(client));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Client from(CreateClientRequest request){
        Client client = new Client();
        client.setName(request.getName());
        client.setLastname(request.getLastname());
        client.setAge(request.getAge());
        client.setCurp(request.getCurp());
        return client;
    }

    private CreateClientResponse from(Client client){
        CreateClientResponse response = new CreateClientResponse();
        response.setId(client.getId());
        response.setName(client.getName());
        response.setLastname(client.getLastname());
        response.setAge(client.getAge());
        response.setCurp(client.getCurp());
        return response;
    }

    private Client findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
    
}
