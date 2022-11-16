package com.pratishkatiyar.cab.booking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Driver {
  String id;
  String driverName;
  char gender;
  int age;


  @Setter Trip currentTrip;
  @Setter Boolean isAvailable;

  public Driver(String id, String driverName, char gender, int age) {
    this.id = id;
    this.driverName = driverName;
    this.isAvailable = true;
    this.gender=gender;
    this.age=age;
  }

  @Override
  public String toString() {
    return "Cab{" +
        "id='" + id + '\'' +
        ", driverName='" + driverName + '\'' +
        ", isAvailable=" + isAvailable +
        '}';
  }
}
