package com.example.demo.repositories;

import com.example.demo.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDestinationRepository extends JpaRepository<Destination, Long> {
}
