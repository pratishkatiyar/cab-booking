package com.pratishkatiyar.cab.booking.controllers;

import com.pratishkatiyar.cab.booking.database.UsersManager;
import com.pratishkatiyar.cab.booking.database.TripsManager;
import com.pratishkatiyar.cab.booking.model.Location;
import com.pratishkatiyar.cab.booking.model.User;
import com.pratishkatiyar.cab.booking.model.Trip;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
  private UsersManager usersManager;
  private TripsManager tripsManager;

  public UsersController(UsersManager usersManager, TripsManager tripsManager) {
    this.usersManager = usersManager;
    this.tripsManager = tripsManager;
  }

  @RequestMapping(value = "/register/user", method = RequestMethod.POST)
  public ResponseEntity registerUser(final User user) {
    usersManager.createUser(user);
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "/book", method = RequestMethod.POST)
  public ResponseEntity book(
      final String UserId,
      final Double sourceX,
      final Double sourceY,
      final Double destX,
      final Double destY) {

    tripsManager.createTrip(usersManager.getUser(UserId), new Location(sourceX, sourceY), new Location(destX, destY));

    return ResponseEntity.ok("");
  }
}
