package com.pratishkatiyar.cab.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class User {
  String id;
  String name;
  char gender;
  int age;
}
