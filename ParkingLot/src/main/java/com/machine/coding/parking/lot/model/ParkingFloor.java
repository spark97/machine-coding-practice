package com.machine.coding.parking.lot.model;

import java.util.List;

public class ParkingFloor {

    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
