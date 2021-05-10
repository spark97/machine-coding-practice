package com.machine.coding.ride.sharing.service;

import com.machine.coding.ride.sharing.model.User;
import com.machine.coding.ride.sharing.model.Vehicle;

import java.util.HashMap;

public class VehicleService {

    private HashMap<String, Vehicle> vehicles;

    private UserService userService;

    private static VehicleService instance;

    private VehicleService(){
        this.vehicles = new HashMap<>();
        this.userService = UserService.getInstance();
    }

    public static VehicleService getInstance(){
        if(instance == null)
            instance = new VehicleService();
        return instance;
    }

    public void addVehicle(String userId, Vehicle vehicle){
        this.userService.getUser(userId).getVehicles().add(vehicle.getId());
        vehicles.put(vehicle.getId(), vehicle);
    }

    public HashMap<String, Vehicle> getVehicles(){
        return this.vehicles;
    }


}
