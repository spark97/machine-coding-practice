package com.machine.coding.ride.sharing.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;

    private String name;

    private List<String> vehicles;

    private List<String> ridesOffered;

    private List<String> ridesTaken;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.vehicles = new ArrayList<>();
        this.ridesOffered = new ArrayList<>();
        this.ridesTaken = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getRidesOffered() {
        return ridesOffered;
    }

    public void setRidesOffered(List<String> ridesOffered) {
        this.ridesOffered = ridesOffered;
    }

    public List<String> getRidesTaken() {
        return ridesTaken;
    }

    public void setRidesTaken(List<String> ridesTaken) {
        this.ridesTaken = ridesTaken;
    }
}
