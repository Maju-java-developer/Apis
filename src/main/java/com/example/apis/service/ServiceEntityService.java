package com.example.apis.service;

import com.example.apis.entities.ServiceEntity;
import com.example.apis.repo.ServiceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceEntityService {

    private final ServiceRepo serviceRepository;

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceEntity createService(ServiceEntity serviceEntity) {
        serviceEntity.setCreatedDate(LocalDateTime.now());
        return serviceRepository.save(serviceEntity);
    }
}

