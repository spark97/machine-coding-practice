package com.machine.coding.parking.lot.model;

public class Vehicle {

    private String regNo;

    private VehicleType vehicleType;

    public Vehicle(String regNo, VehicleType vehicleType) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
