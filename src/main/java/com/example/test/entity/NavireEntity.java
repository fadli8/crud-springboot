package com.example.test.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.SpringVersion;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Data @Table @Builder
public class NavireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double tonnage;
    private LocalDateTime date_integration;
    private LocalDateTime date_demarage;
    private String status;

}
