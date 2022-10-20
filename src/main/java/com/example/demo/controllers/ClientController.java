package com.example.demo.controllers;

import com.example.demo.controllers.dtos.request.CreateClientRequest;
import com.example.demo.controllers.dtos.responses.CreateClientResponse;
import com.example.demo.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class ClientController{
    @Autowired
    private IClientService service;


    @PostMapping
    public CreateClientResponse create(@RequestBody CreateClientRequest request) {
        return service.create(request);
    }

    @GetMapping("{id}")
    public CreateClientResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<CreateClientResponse> list() {
        return service.list();
    }

    @PutMapping("{id}")
    public CreateClientResponse update(@PathVariable Long id, @RequestBody CreateClientRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

