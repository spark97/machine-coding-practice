package com.machine.coding.parking.lot.main;

import com.machine.coding.parking.lot.model.ParkingSlotStatus;
import com.machine.coding.parking.lot.model.ParkingTicket;
import com.machine.coding.parking.lot.model.Vehicle;
import com.machine.coding.parking.lot.model.VehicleType;
import com.machine.coding.parking.lot.service.ParkingLotService;
import com.machine.coding.parking.lot.service.ParkingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DriverClass {

    public static void main(String[] args) {

        ParkingLotService parkingLotService = ParkingLotService.getInstance();
        ParkingService parkingService = ParkingService.getInstance();

        while(true){
            System.out.println("1. Create parking lot");
            System.out.println("2. Display Free Count");
            System.out.println("3. Display Free Slots");
            System.out.println("4. Display Occupied Slots");
            System.out.println("5. Park vehicle");
            System.out.println("6. UnPark vehicle");
            System.out.println("7. Exit");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    createParkingLot(parkingLotService);
                    break;
                case 2:
                    displayFreeCount(parkingLotService);
                    break;
                case 3:
                    displayFreeSlots(parkingLotService);
                    break;
                case 4:
                    displayOccupiedSlots(parkingLotService);
                    break;
                case 5:
                    parkVehicle(parkingService);
                    break;
                case 6:
                    unparkVehilce(parkingService);
                    break;
                case 7:
                    return;
            }
        }
    }

    private static void createParkingLot(ParkingLotService parkingLotService){
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        int noFloors = scanner.nextInt();
        int noSlots = scanner.nextInt();
        parkingLotService.addParkingLot(id, noFloors, noSlots);
    }

    private static void displayFreeCount(ParkingLotService parkingLotService){
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        VehicleType vehicleType = null;
        if(type.equals("CAR"))
            vehicleType = VehicleType.CAR;
        else if(type.equals("TRUCK"))
            vehicleType = VehicleType.TRUCK;
        else if(type.equals("BIKE"))
            vehicleType = VehicleType.BIKE;
        else
            return;
        HashMap<Integer, Integer> res = parkingLotService.getSlotsCountWithGivenStatus(vehicleType, ParkingSlotStatus.AVAILABLE);
        for(Map.Entry<Integer, Integer> entry : res.entrySet()){
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void parkVehicle(ParkingService parkingService){
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        VehicleType vehicleType = null;
        if(type.equals("CAR"))
            vehicleType = VehicleType.CAR;
        else if(type.equals("TRUCK"))
            vehicleType = VehicleType.TRUCK;
        else if(type.equals("BIKE"))
            vehicleType = VehicleType.BIKE;
        else
            return;
      String regNo = scanner.nextLine();
      Vehicle vehicle = new Vehicle(regNo, vehicleType);
        ParkingTicket parkingTicket = parkingService.parkVehicle(vehicle);
        if(parkingTicket==null){
            System.out.println("Parking lot full");
            return;
        }
        else
        {
            System.out.println("Parked Vehicle. " + parkingTicket.getTicketId());
        }
    }

    private static void unparkVehilce(ParkingService parkingService){
        Scanner scanner = new Scanner(System.in);
        String regNo = scanner.nextLine();
        parkingService.unparkVehilce(regNo);
    }

    private static void displayFreeSlots(ParkingLotService parkingLotService){
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        VehicleType vehicleType = null;
        if(type.equals("CAR"))
            vehicleType = VehicleType.CAR;
        else if(type.equals("TRUCK"))
            vehicleType = VehicleType.TRUCK;
        else if(type.equals("BIKE"))
            vehicleType = VehicleType.BIKE;
        else
            return;
        HashMap<Integer, List<Integer>> res = parkingLotService.displaySlotsWithGivenStatus(vehicleType, ParkingSlotStatus.AVAILABLE);
        for(Map.Entry<Integer, List<Integer>> entry : res.entrySet()){
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + entry.getKey() + ": " + getStringFromList(entry.getValue()));
        }
    }

    private static void displayOccupiedSlots(ParkingLotService parkingLotService){
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        VehicleType vehicleType = null;
        if(type.equals("CAR"))
            vehicleType = VehicleType.CAR;
        else if(type.equals("TRUCK"))
            vehicleType = VehicleType.TRUCK;
        else if(type.equals("BIKE"))
            vehicleType = VehicleType.BIKE;
        else
            return;
        HashMap<Integer, List<Integer>> res = parkingLotService.displaySlotsWithGivenStatus(vehicleType, ParkingSlotStatus.OCCUPIED);
        for(Map.Entry<Integer, List<Integer>> entry : res.entrySet()){
            System.out.println("Occupied slots for " + vehicleType + " on Floor " + entry.getKey() + ": " + getStringFromList(entry.getValue()));
        }
    }

    private static String getStringFromList(List<Integer> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i : list){
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        String res = stringBuilder.toString();
        if(res.isEmpty())
            return res.toString();
        return  res.substring(0, res.length()-1);
    }

}
