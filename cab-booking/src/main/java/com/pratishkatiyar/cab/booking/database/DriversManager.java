package com.pratishkatiyar.cab.booking.database;

import com.pratishkatiyar.cab.booking.exceptions.CaptainAlreadyExistsException;
import com.pratishkatiyar.cab.booking.exceptions.CaptainNotFoundException;
import com.pratishkatiyar.cab.booking.model.Driver;
import com.pratishkatiyar.cab.booking.model.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pratishkatiyar.cab.booking.model.Captain;
import lombok.NonNull;

public class DriversManager {
  Map<String, Captain> captains = new HashMap<>();
  public void createDriver(@NonNull final Captain captain) {
    if (captains.containsKey(captain.getDriver().getId())) {
      throw new CaptainAlreadyExistsException();
    }

    captains.put(captain.getDriver().getId(), captain);
  }

  public List<Driver> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance) {
    List<Driver> result = new ArrayList<>();
    for (Captain cab : captains.values()) {
      if (cab.getDriver().getIsAvailable() && cab.getLocation().distance(fromPoint) <= distance) {
        result.add(cab.getDriver());
      }
    }
    return result;
  }
}
