package com.api.parkincontrol.repositories;

import com.api.parkincontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Long> {
}
