package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="comments")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


}
    private Long id;
    private String name;
    private String lastname;
    private Integer age;
    private String curp;