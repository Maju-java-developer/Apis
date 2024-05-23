package com.example.apis.controller;

import com.example.apis.entities.WorkerEntity;
import com.example.apis.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

    private WorkerService workerService;

    @PostMapping("getAllWorkers")
    public List<WorkerEntity> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @PostMapping("createWorker")
    public WorkerEntity createWorker(@RequestBody WorkerEntity worker) {
        return workerService.createWorker(worker);
    }

}

