package com.example.apis.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "SERVICES")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Integer serviceId;
    @JoinColumn(name = "SERVICE_NAME", nullable = false, unique = true)
    private String serviceName;
    @JoinColumn(name = "SERVICE_URL", nullable = false, unique = true)
    private String serviceUrl;
    @JsonIgnore
    private LocalDateTime createdDate;

//    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
//    List<WorkerEntity> workers;
}
