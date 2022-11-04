package com.api.parkincontrol.controllers;

import com.api.parkincontrol.services.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/parking-spot/")
public class ParkingSpotController {

     private final ParkingSpotService parkingSpotService;





}
