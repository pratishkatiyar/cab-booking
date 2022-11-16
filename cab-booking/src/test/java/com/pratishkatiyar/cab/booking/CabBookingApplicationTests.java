package com.pratishkatiyar.cab.booking;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pratishkatiyar.cab.booking.controllers.DriversController;
import com.pratishkatiyar.cab.booking.controllers.UsersController;
import com.pratishkatiyar.cab.booking.database.DriversManager;
import com.pratishkatiyar.cab.booking.database.UsersManager;
import com.pratishkatiyar.cab.booking.database.TripsManager;
import com.pratishkatiyar.cab.booking.model.Driver;
import com.pratishkatiyar.cab.booking.model.Location;
import com.pratishkatiyar.cab.booking.model.User;
import com.pratishkatiyar.cab.booking.model.Vehicle;
import com.pratishkatiyar.cab.booking.strategies.CabMatchingStrategy;
import com.pratishkatiyar.cab.booking.strategies.DefaultCabMatchingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabBookingApplicationTests {
	DriversController driversController;
	UsersController usersController;

	@BeforeEach
	void setUp() {
		DriversManager cabsManager = new DriversManager();
		UsersManager ridersManager = new UsersManager();

		CabMatchingStrategy cabMatchingStrategy = new DefaultCabMatchingStrategy();

		TripsManager tripsManager = new TripsManager(cabsManager, ridersManager, cabMatchingStrategy);

		driversController = new DriversController(cabsManager, tripsManager);
		usersController = new UsersController(ridersManager, tripsManager);
	}

	@Test
	void testCabBookingFlow() {

		Driver cab1 = new Driver("d1", "Driver1", 'M', 22);
		Vehicle vehicle1= new Vehicle("Swift1", "KA-01-12345");
		Location location1 = new Location(10.0,1.0);
		driversController.registerDriver(cab1,vehicle1,location1);

		Driver cab2 = new Driver("d2", "Driver2", 'M', 29);
		Vehicle vehicle2 = new Vehicle("Swift2", "KA-02-12345");
		Location location2 = new Location(11.0,10.0);
		driversController.registerDriver(cab2,vehicle2,location2);

		Driver cab3 = new Driver("d3", "Driver3", 'M', 24);
		Vehicle vehicle3 = new Vehicle("Swift3", "KA-03-12345");
		Location location3 = new Location(5.0,3.0);
		driversController.registerDriver(cab3, vehicle3, location3);


		User user1 = new User("u1", "Abhishek", 'M', 23);
		usersController.registerUser(user1);

		User user2 = new User("u2", "Rahul", 'M', 29);
		usersController.registerUser(user2);

		User user3 = new User("u3", "Nandini", 'F', 22);
		usersController.registerUser(user3);

		DriversManager cabsManager = new DriversManager();


		usersController.book("u1", 0.0, 0.0, 20.0, 1.0);
		usersController.book("u2", 10.0, 0.0, 15.0, 3.0);
		usersController.book("u2", 15.0, 6.0, 20.0, 4.0);
	}
}
