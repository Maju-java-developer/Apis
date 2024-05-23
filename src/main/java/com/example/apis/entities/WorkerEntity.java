package com.example.apis.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "WORKERS")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WORKER_ID", updatable = false, nullable = false)
    private Integer workerId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "HOURLY_RATE", nullable = false)
    private Double hourlyRate;

    @Column(name = "ADDRESS", length = 255)
    private String address;

    @Column(name = "CONTACT", length = 20)
    private String contact;

    @JsonIgnore
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private ServiceEntity service;
}
