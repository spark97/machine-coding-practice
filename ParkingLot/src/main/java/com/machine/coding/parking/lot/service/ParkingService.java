package com.machine.coding.parking.lot.service;

import com.machine.coding.parking.lot.model.*;

import java.util.HashMap;
import java.util.List;

public class ParkingService {

    private static ParkingService instance;

    private ParkingLotService parkingLotService;

    private HashMap<String, ParkingTicket> parkingTicketHashMap;

    private ParkingService(){
        this.parkingLotService = ParkingLotService.getInstance();
        this.parkingTicketHashMap = new HashMap<>();
    }

    public static ParkingService getInstance(){
        if(instance==null)
            instance = new ParkingService();
        return instance;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle){
        ParkingTicket parkingTicket = null;
        VehicleType vehicleType = vehicle.getVehicleType();
        ParkingLot parkingLot = parkingLotService.getParkingLot();
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        int parkingFloorNumber = -1;
        int parkingSlotNumber = -1;
        boolean found = false;
        for(int i=0;i<parkingFloors.size();i++){
            ParkingFloor parkingFloor = parkingFloors.get(i);
            for(int j=0; j<parkingFloor.getParkingSlots().size();j++){
                ParkingSlot parkingSlot = parkingFloor.getParkingSlots().get(j);
                if(parkingSlot.getParkingSlotStatus()==ParkingSlotStatus.AVAILABLE && parkingSlot.getVehicleType()==vehicleType) {
                        parkingFloorNumber  = i;
                        parkingSlotNumber = j;
                        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
                        found=true;
                        break;
                }
            }
            if(found)
                break;
        }
        if(found){
            parkingTicket = new ParkingTicket(vehicle, parkingFloorNumber, parkingSlotNumber, parkingLotService.getParkingLot().getId(), TicketStatus.ACTIVE);
            this.parkingTicketHashMap.put(parkingTicket.getTicketId(), parkingTicket);
        }
        return parkingTicket;
    }

    public void unparkVehilce(String ticketId){
        ParkingTicket parkingTicket = this.parkingTicketHashMap.get(ticketId);
        if(parkingTicket==null || parkingTicket.getTicketStatus()==TicketStatus.COMPLETED){
            System.out.println("Invalid Ticket");
            return;
        }
        int parkingFloorNumber = parkingTicket.getParkingFloor();
        int parkingSlotNumber = parkingTicket.getParkingSlot();
        ParkingLot parkingLot = parkingLotService.getParkingLot();
        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(parkingFloorNumber);
        ParkingSlot parkingSlot = parkingFloor.getParkingSlots().get(parkingSlotNumber);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingTicket.setTicketStatus(TicketStatus.COMPLETED);
        System.out.println("Unparked vehicle with reg id: " + parkingTicket.getVehicle().getRegNo());
    }

}
