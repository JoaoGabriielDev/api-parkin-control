package com.api.parkincontrol.controllers;

import com.api.parkincontrol.dtos.ParkingSpotDto;
import com.api.parkincontrol.models.ParkingSpotModel;
import com.api.parkincontrol.services.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/parking-spot/")
public class ParkingSpotController {

     private final ParkingSpotService parkingSpotService;

     @PostMapping
     public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
          if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
               return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
          }
          if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
               return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
          }
          if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
               return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
          }
          var parkingSpotModel = new ParkingSpotModel();
          BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
          parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
          return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
     }

     @GetMapping
     public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
          return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
     }


}
