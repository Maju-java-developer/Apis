package com.example.apis.repo;

import com.example.apis.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepo extends JpaRepository<WorkerEntity, Integer> {
    boolean existsByEmail(String email);
    List<WorkerEntity> findAllByServiceServiceId(Integer serviceId);
}
