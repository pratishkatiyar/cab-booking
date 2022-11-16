package com.pratishkatiyar.cab.booking.model;

import lombok.Data;

@Data
public class Captain {
    private Driver driver;
    private Vehicle vehicle;
    private Location location;

    public Captain(Driver driver, Vehicle vehicle, Location location) {
        this.driver =driver;
        this.vehicle=vehicle;
        this.location=location;
    }
}
