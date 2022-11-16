package com.pratishkatiyar.cab.booking.database;

import com.pratishkatiyar.cab.booking.exceptions.NoCaptainAvailableException;
import com.pratishkatiyar.cab.booking.model.Driver;
import com.pratishkatiyar.cab.booking.model.Location;
import com.pratishkatiyar.cab.booking.model.User;
import com.pratishkatiyar.cab.booking.model.Trip;
import com.pratishkatiyar.cab.booking.strategies.CabMatchingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.NonNull;

public class TripsManager {

  public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 1000.0;
  private Map<String, List<Trip>> trips = new HashMap<>();

  private DriversManager driversManager;
  private UsersManager usersManager;
  private CabMatchingStrategy cabMatchingStrategy;

  public TripsManager(
      DriversManager cabsManager,
      UsersManager ridersManager,
      CabMatchingStrategy cabMatchingStrategy) {
    this.driversManager = cabsManager;
    this.usersManager = ridersManager;
    this.cabMatchingStrategy = cabMatchingStrategy;
  }

  public void createTrip(
      @NonNull final User user,
      @NonNull final Location fromPoint,
      @NonNull final Location toPoint) {
    final List<Driver> closeByCabs = driversManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
    final List<Driver> closeByAvailableCabs = closeByCabs.stream().filter(cab -> cab.getCurrentTrip() == null).collect(Collectors.toList());

    final Driver selectedCab = cabMatchingStrategy.matchCabToRider(user, closeByAvailableCabs, fromPoint, toPoint);
    if (selectedCab == null) {
      throw new NoCaptainAvailableException();
    }

    final Trip newTrip = new Trip(user, selectedCab, fromPoint, toPoint);
    if (!trips.containsKey(user.getId())) {
      trips.put(user.getId(), new ArrayList<>());
    }
    trips.get(user.getId()).add(newTrip);
    selectedCab.setCurrentTrip(newTrip);
  }

}
