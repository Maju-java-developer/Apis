package com.example.apis.controller;

import com.example.apis.entities.ServiceEntity;
import com.example.apis.service.ServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("services")
public class ServiceController {

    @Autowired
    private ServiceEntityService serviceEntityService;

    @PostMapping("getAllService")
    public ResponseEntity<?> getAllServices() {
        List<ServiceEntity> services = serviceEntityService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @PostMapping("createService")
    public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceEntity serviceEntity) {
        ServiceEntity createdService = serviceEntityService.createService(serviceEntity);
        return ResponseEntity.ok(createdService);
    }

}