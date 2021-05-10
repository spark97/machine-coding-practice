package com.machine.coding.ride.sharing.main;

import com.machine.coding.ride.sharing.model.Ride;
import com.machine.coding.ride.sharing.model.RideStatus;
import com.machine.coding.ride.sharing.model.User;
import com.machine.coding.ride.sharing.model.Vehicle;
import com.machine.coding.ride.sharing.service.RideService;
import com.machine.coding.ride.sharing.service.UserService;
import com.machine.coding.ride.sharing.service.VehicleService;

public class DriverClass{

    public static void main(String[] args) {

        UserService userService = UserService.getInstance();
        RideService rideService = RideService.getInstance();
        VehicleService vehicleService = VehicleService.getInstance();

        User userRohan = new User("1", "Rohan");
        User userShashank = new User("2", "Shashank");
        User userNandini = new User("3", "Nandini");
        User userGaurav = new User("4", "Gaurav");
        User userShipra = new User("5", "Shipra");
        User userRahul = new User("6", "Rahul");

        userService.addUser(userRohan);
        userService.addUser(userNandini);
        userService.addUser(userShashank);
        userService.addUser(userGaurav);
        userService.addUser(userShipra);
        userService.addUser(userRahul);

        Vehicle vehicleRohan1 = new Vehicle("1", "KA-01-12345", "Swift");
        Vehicle vehicleShashank1 = new Vehicle("2", "TS-05-62395", "Baleno");
        Vehicle vehicleShipra1 = new Vehicle("3", "KA-05-41491", "Polo");
        Vehicle vehicleShipra2 = new Vehicle("4", "KA-12-12332", "Activa");
        Vehicle vehicleRahul1 = new Vehicle("5", "KA-05-1234", "XUV");

        vehicleService.addVehicle("1", vehicleRohan1);
        vehicleService.addVehicle("2", vehicleShashank1);
        vehicleService.addVehicle("5", vehicleShipra1);
        vehicleService.addVehicle("5", vehicleShipra2);
        vehicleService.addVehicle("6", vehicleRahul1);

        Ride rideRohan1 = new Ride("1", "1", RideStatus.OFFERED, "1", "Hyderabad", "Bangalore",1);
        Ride rideShipra1 = new Ride("2", "5", RideStatus.OFFERED, "4", "Bangalore", "Mysore",1);
        Ride rideShipra2 = new Ride("3", "5", RideStatus.OFFERED, "3", "Bangalore", "Mysore",2);
        Ride rideShashank = new Ride("4", "2", RideStatus.OFFERED, "2", "Hyderabad", "Bangalore",2);
        Ride rideRahul = new Ride("5", "6", RideStatus.OFFERED, "5", "Hyderabad", "Bangalore",5);
        Ride rideRohan2 = new Ride("6", "1", RideStatus.OFFERED, "1", "Bangalore", "Pune",1);

        rideService.offerRide(rideRohan1);
        rideService.offerRide(rideShipra1);
        rideService.offerRide(rideShipra2);
        rideService.offerRide(rideShashank);
        rideService.offerRide(rideRahul);
        rideService.offerRide(rideRohan2);

        Ride rideNandini1 = rideService.selectRide("3", "Bangalore", "Mysore", 1, "MOST_VACANT");
        System.out.println(rideNandini1.getId());
        Ride rideGaurav1 = rideService.selectRide("4", "Bangalore", "Mysore", 1, "Activa");
        System.out.println(rideGaurav1.getId());
        Ride rideShashank1 = rideService.selectRide("2", "Mumbai", "Bangalore", 1, "MOST_VACANT");
        System.out.println(rideShashank1==null?"No rides" : rideShashank1.getId());
        Ride rideRohan1search = rideService.selectRide("1", "Hyderabad", "Bangalore", 1, "Baleno");
        System.out.println(rideRohan1search.getId());
        Ride rideShashank2 = rideService.selectRide("2", "Hyderabad", "Bangalore", 1, "Polo");
        System.out.println(rideShashank2==null?"No rides" : rideShashank2.getId());

        rideService.endRide("1");
        rideService.endRide("2");
        rideService.endRide("3");
        rideService.endRide("4");

        rideService.printRideStats();

    }

}
