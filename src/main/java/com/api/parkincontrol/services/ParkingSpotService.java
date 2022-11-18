package com.api.parkincontrol.services;

import com.api.parkincontrol.models.ParkingSpotModel;
import org.springframework.data.domain.Page;
import java.awt.print.Pageable;
import java.util.Optional;

public interface ParkingSpotService {


     ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

     boolean existsByLicensePlateCar(String licensePlateCar);

     boolean existsByParkingSpotNumber(String parkingSpotNumber);

     boolean existsByApartmentAndBlock(String apartment, String block);

    Page<ParkingSpotModel> findAll(Pageable pageable);

    Optional<ParkingSpotModel> findById(Long id);

    void delete(ParkingSpotModel parkingSpotModel);

}
