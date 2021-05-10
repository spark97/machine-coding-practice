package com.machine.coding.ride.sharing.model;

public class Vehicle {

    private String id;

    private String licensePlate;

    private String name;

    public Vehicle(String id, String licensePlate, String name) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
