package com.api.parkincontrol.services;

import com.api.parkincontrol.repositories.ParkingSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class ParkingSpotServiceImpl implements ParkingSpotService{

    private final ParkingSpotRepository parkingSpotRepository;






}
