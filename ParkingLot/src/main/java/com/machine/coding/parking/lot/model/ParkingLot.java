package com.machine.coding.parking.lot.model;

import java.util.HashMap;
import java.util.List;

public class ParkingLot {

    private List<ParkingFloor> parkingFloors;

    private String id;

    public ParkingLot(List<ParkingFloor> parkingFloors, String id) {
        this.parkingFloors = parkingFloors;
        this.id = id;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public String getId() {
        return id;
    }
}
