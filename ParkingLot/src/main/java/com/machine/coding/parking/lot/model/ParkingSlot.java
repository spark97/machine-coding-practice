package com.machine.coding.parking.lot.model;

public class ParkingSlot {

    private VehicleType vehicleType;

    private ParkingSlotStatus parkingSlotStatus;

    public ParkingSlot(VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus) {
        this.vehicleType = vehicleType;
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }
}
