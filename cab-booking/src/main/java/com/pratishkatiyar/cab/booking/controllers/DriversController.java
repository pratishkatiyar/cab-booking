package com.pratishkatiyar.cab.booking.controllers;

import com.pratishkatiyar.cab.booking.database.DriversManager;
import com.pratishkatiyar.cab.booking.database.TripsManager;
import com.pratishkatiyar.cab.booking.model.Driver;
import com.pratishkatiyar.cab.booking.model.Location;
import com.pratishkatiyar.cab.booking.model.Vehicle;
import com.pratishkatiyar.cab.booking.model.Captain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriversController {
  private DriversManager driversManager;
  private TripsManager tripsManager;

  public DriversController(DriversManager driversManager, TripsManager tripsManager) {
    this.driversManager = driversManager;
    this.tripsManager = tripsManager;
  }
  @RequestMapping(value = "/register/driver", method = RequestMethod.POST)
  public ResponseEntity registerDriver(final Driver driver, final Vehicle vehicle, final Location location) {
    driversManager.createDriver(new Captain( driver, vehicle, location));
    return ResponseEntity.ok("");
  }
}
