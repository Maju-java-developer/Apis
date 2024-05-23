package com.example.apis.controller;

import com.example.apis.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/emails")
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody Map<String, String> request) {
        try {
            String customerName = request.get("customerName");
            String customerContactNumber = request.get("customerContactNumber");
            String serviceName = request.get("serviceName");
            Integer workerId = Integer.valueOf(request.get("workerId"));
            String customerAddress = request.get("customerAddress");
            String preferredTime = request.get("preferredTime");

            emailService.sendEmail(
                    customerName,
                    customerContactNumber,
                    serviceName,
                    workerId,
                    customerAddress,
                    preferredTime
            );
            return new ResponseEntity<>("Email sent successfully!", HttpStatus.OK);
        } catch (MessagingException e) {
            return new ResponseEntity<>("Failed to send email: " + e.getMessage(), HttpStatus.OK);
        }
    }
}

