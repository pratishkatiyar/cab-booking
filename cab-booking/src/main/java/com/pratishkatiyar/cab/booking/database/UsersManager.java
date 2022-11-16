package com.pratishkatiyar.cab.booking.database;

import com.pratishkatiyar.cab.booking.exceptions.UserAlreadyExistsException;
import com.pratishkatiyar.cab.booking.exceptions.UserNotFoundException;
import com.pratishkatiyar.cab.booking.model.User;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

/** In memory database for storing jobs. */
public class UsersManager {
  Map<String, User> users = new HashMap<>();

  public void createUser(@NonNull final User newUser) {
    if (users.containsKey(newUser.getId())) {
      throw new UserAlreadyExistsException();
    }

    users.put(newUser.getId(), newUser);
  }

  public User getUser(@NonNull final String userId) {
    if (!users.containsKey(userId)) {
      throw new UserNotFoundException();
    }
    return users.get(userId);
  }
}
