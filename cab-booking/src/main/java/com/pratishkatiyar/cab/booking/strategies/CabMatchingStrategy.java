package com.pratishkatiyar.cab.booking.strategies;

import com.pratishkatiyar.cab.booking.model.Driver;
import com.pratishkatiyar.cab.booking.model.Location;
import com.pratishkatiyar.cab.booking.model.User;
import java.util.List;

public interface CabMatchingStrategy {

  Driver matchCabToRider(User user, List<Driver> candidateCabs, Location fromPoint, Location toPoint);
}
