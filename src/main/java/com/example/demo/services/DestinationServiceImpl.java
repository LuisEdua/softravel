package com.example.demo.services;

import com.example.demo.controllers.dtos.request.CreateClientRequest;
import com.example.demo.controllers.dtos.request.CreateDestinationRequest;
import com.example.demo.controllers.dtos.responses.CreateClientResponse;
import com.example.demo.controllers.dtos.responses.CreateDestinationResponse;
import com.example.demo.entities.Client;
import com.example.demo.entities.Destination;
import com.example.demo.repositories.IDestinationRepository;
import com.example.demo.services.interfaces.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationServiceImpl implements IDestinationService {
    @Autowired
    private IDestinationRepository repository;


    @Override
    public CreateDestinationResponse create(CreateDestinationRequest request) {
        Destination save = repository.save(from(request));

        return from(save);
    }

    @Override
    public CreateDestinationResponse get(Long id) {
        Destination destination = findAndEnsureExist(id);
        return from(destination);
    }

    @Override
    public List<CreateDestinationResponse> list() {
        return repository.findAll().stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public CreateDestinationResponse update(Long id, CreateDestinationRequest request) {
        Destination destination = findAndEnsureExist(id);
<<<<<<< HEAD
        destination.set
        return from(repository.save(client));
=======
        destination.setState(request.getState());
        destination.setCheckInTime(request.getCheckInTime());
        destination.setPostalCode(request.getPostalCode());
        return from(repository.save(destination));
>>>>>>> 26fe7952684a3546ceee443eb85b024c6ab9956a
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Destination from(CreateDestinationRequest request){
        Destination destination = new Destination();
        destination.setState(request.getState());
        destination.setCheckInTime(request.getCheckInTime());
        destination.setPostalCode(request.getPostalCode());
        return destination;
    }

    private CreateDestinationResponse from(Destination destination){
        CreateDestinationResponse response = new CreateDestinationResponse();
        response.setId(destination.getId());
        destination.setState(destination.getState());
        destination.setCheckInTime(destination.getCheckInTime());
        destination.setPostalCode(destination.getPostalCode());
        return response;
    }

    private Destination findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
    
}
