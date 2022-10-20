package com.example.demo.services;

import com.example.demo.controllers.dtos.request.CreatePaymentRequest;
import com.example.demo.controllers.dtos.responses.CreatePaymentResponse;
import com.example.demo.entities.Destination;
import com.example.demo.entities.Payment;
import com.example.demo.repositories.IPaymentRepository;
import com.example.demo.services.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private IPaymentRepository repository;

    @Override
    public CreatePaymentResponse create(CreatePaymentRequest request) {
        Payment save = repository.save(from(request));

        return from(save);
    }

    @Override
    public CreatePaymentResponse get(Long id) {
        Payment payment = findAndEnsureExist(id);
        return from(payment);
    }

    @Override
    public List<CreatePaymentResponse> list() {
        return repository.findAll().stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public CreatePaymentResponse update(Long id, CreatePaymentRequest request) {
        Payment payment = findAndEnsureExist(id);
        payment.setPaymentType(request.getPaymentType());
        payment.setCost(request.getCost());
        return from(repository.save(payment));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Payment from (CreatePaymentRequest request){
        Payment payment = new Payment();
        payment.setCost(request.getCost());
        payment.setPaymentType(request.getPaymentType());
        return payment;
    }

    private CreatePaymentResponse from (Payment payment){
        CreatePaymentResponse response = new CreatePaymentResponse();
        response.setCost(payment.getCost());
        response.setPaymentType(payment.getPaymentType());
        return response;
    }

    private Payment findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }
}
