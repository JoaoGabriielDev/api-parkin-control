package com.api.parkincontrol.repositories;

import com.api.parkincontrol.models.ParkingSpotModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Long> {

    boolean existsByLicensePlateCar(String licensePlateCar);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    boolean existsByApartmentAndBlock(String apartment, String block);

    Page<ParkingSpotModel> findAll(Pageable pageable);
}
