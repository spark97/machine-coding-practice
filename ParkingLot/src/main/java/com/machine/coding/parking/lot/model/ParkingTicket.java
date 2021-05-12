package com.machine.coding.parking.lot.model;

public class ParkingTicket {

    private Vehicle vehicle;

    private int parkingFloor;

    private int parkingSlot;

    private String parkingLotId;

    private TicketStatus ticketStatus;

    public ParkingTicket(Vehicle vehicle, int parkingFloor, int parkingSlot, String parkingLotId, TicketStatus ticketStatus) {
        this.vehicle = vehicle;
        this.parkingFloor = parkingFloor;
        this.parkingSlot = parkingSlot;
        this.parkingLotId = parkingLotId;
        this.ticketStatus = ticketStatus;
    }

    public String getTicketId(){
        return this.parkingLotId.concat("_")
                .concat(String.valueOf(this.parkingFloor))
                .concat("_")
                .concat(String.valueOf(this.parkingSlot));
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getParkingFloor() {
        return parkingFloor;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
