package com.example.demo.services;

import com.example.demo.controllers.dtos.request.CreateDestinationRequest;
import com.example.demo.controllers.dtos.responses.CreateDestinationResponse;
import com.example.demo.entities.Destination;
import com.example.demo.repositories.IDestinationRepository;
import com.example.demo.services.interfaces.IClientService;
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
        destination.setPostalCode(request.getPostalCode());
        destination.setState(request.getState());
        destination.setCheckInTime(request.getCheckInTime());
        return from(repository.save(destination));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Destination from(CreateDestinationRequest request){
        Destination destination = new Destination();
        destination.setPostalCode(request.getPostalCode());
        destination.setState(request.getState());
        destination.setCheckInTime(request.getCheckInTime());
        return destination;
    }

    private CreateDestinationResponse from(Destination destination){
        CreateDestinationResponse response = new CreateDestinationResponse();
        response.setPostalCode(destination.getPostalCode());
        response.setState(destination.getState());
        response.setCheckInTime(destination.getCheckInTime());
        return response;
    }

    private Destination findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
    
}
