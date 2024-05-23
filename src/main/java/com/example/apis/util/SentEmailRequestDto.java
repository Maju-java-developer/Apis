package com.example.apis.util;

import lombok.Data;

@Data
public class SentEmailRequestDto {
    private String name;
    private String contactNumber;
    private String service;
    private String worker;
    private String address;
    private String preferredTime;
}
