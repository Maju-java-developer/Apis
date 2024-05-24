package com.example.apis.service;

import com.example.apis.entities.WorkerEntity;
import com.example.apis.execption.DuplicateEmailException;
import com.example.apis.repo.WorkerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class WorkerService {

    private final WorkerRepo workerRepository;

    public List<WorkerEntity> getAllWorkers() {
        return workerRepository.findAll();
    }

    public List<WorkerEntity> findAllByServiceId(Integer serviceId) {
        if (serviceId == null) {
            throw new RuntimeException("ServiceId is required!");
        }
        return workerRepository.findAllByServiceServiceId(serviceId);
    }

    public WorkerEntity createWorker(WorkerEntity worker) {
        // Check if a worker with the same email already exists
        if (workerRepository.existsByEmail(worker.getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + worker.getEmail());
        }
        worker.setCreatedDate(LocalDateTime.now());
        return workerRepository.save(worker);
    }

}

