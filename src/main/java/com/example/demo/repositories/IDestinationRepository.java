package com.example.demo.repositories;

import com.example.demo.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDestinationRepository extends JpaRepository<Destination, Long> {
}
