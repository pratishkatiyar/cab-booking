package com.pratishkatiyar.cab.booking.model;

import static com.pratishkatiyar.cab.booking.model.TripStatus.FINISHED;
import static com.pratishkatiyar.cab.booking.model.TripStatus.IN_PROGRESS;

import lombok.NonNull;
import lombok.ToString;

enum TripStatus {
  IN_PROGRESS,
  FINISHED
}

@ToString
public class Trip {
  private User rider;
  private Driver driver;
  private TripStatus status;
  private Location fromPoint;
  private Location toPoint;

  public Trip(
      @NonNull final User rider,
      @NonNull final Driver driver,
      @NonNull final Location fromPoint,
      @NonNull final Location toPoint) {
    this.rider = rider;
    this.driver = driver;
    this.fromPoint = fromPoint;
    this.toPoint = toPoint;
    this.status = IN_PROGRESS;
  }

  public void endTrip() {
    this.status = FINISHED;
  }
}
