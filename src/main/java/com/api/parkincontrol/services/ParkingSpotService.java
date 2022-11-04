package com.api.parkincontrol.services;

import com.api.parkincontrol.models.ParkingSpotModel;

public interface ParkingSpotService {


     ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

     boolean existsByLicensePlateCar(String licensePlateCar);

     boolean existsByParkingSpotNumber(String parkingSpotNumber);

     boolean existsByApartmentAndBlock(String apartment, String block);
}
