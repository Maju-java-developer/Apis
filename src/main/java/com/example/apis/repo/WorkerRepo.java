package com.example.apis.repo;

import com.example.apis.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepo extends JpaRepository<WorkerEntity, Integer> {
    boolean existsByEmail(String email);
}
