package com.pratishkatiyar.cab.booking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Vehicle {
    @Setter String id;
    @Setter String name;

    public Vehicle(String name, String carNumber) {
        this.id = carNumber;
        this.name = name;
    }
}
