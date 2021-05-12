package com.machine.coding.parking.lot.service;

import com.machine.coding.parking.lot.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {

    private static ParkingLotService instance;

    private ParkingLot parkingLot;

    private ParkingLotService(){

    }

    public static ParkingLotService getInstance(){
        if(instance == null)
            instance = new ParkingLotService();
        return instance;
    }

    public void addParkingLot(String id, int floors, int slotsOnEachFloor){
        int truckSlotsCount = slotsOnEachFloor>=1?1:0;
        int bikeSlotsCount = (slotsOnEachFloor-truckSlotsCount)>=2?2:(slotsOnEachFloor-truckSlotsCount);
        int carSlotsCount = (slotsOnEachFloor-(truckSlotsCount+bikeSlotsCount))>0?(slotsOnEachFloor-(truckSlotsCount+bikeSlotsCount)):0;
        List<ParkingFloor> parkingFloorHashMap = new ArrayList<>();
        for(int i=0; i<floors; i++){
            List<ParkingSlot> parkingSlotList = new ArrayList<>();
            for(int j=0;j<truckSlotsCount;j++){
                ParkingSlot parkingSlot = new ParkingSlot(VehicleType.TRUCK, ParkingSlotStatus.AVAILABLE);
                parkingSlotList.add(parkingSlot);
            }
            for(int j=0;j<bikeSlotsCount;j++){
                ParkingSlot parkingSlot = new ParkingSlot(VehicleType.BIKE, ParkingSlotStatus.AVAILABLE);
                parkingSlotList.add(parkingSlot);
            }
            for(int j=0;j<carSlotsCount;j++){
                ParkingSlot parkingSlot = new ParkingSlot(VehicleType.CAR, ParkingSlotStatus.AVAILABLE);
                parkingSlotList.add(parkingSlot);
            }
            ParkingFloor parkingFloor = new ParkingFloor(parkingSlotList);
            parkingFloorHashMap.add(parkingFloor);
        }
       this.parkingLot = new ParkingLot(parkingFloorHashMap, id);
    }

    public HashMap<Integer, Integer> getSlotsCountWithGivenStatus(VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus){
        List<ParkingFloor> parkingFloors = this.parkingLot.getParkingFloors();
        HashMap<Integer,Integer> countsHashMap = new HashMap<>();
        for(int i=0;i<parkingFloors.size();i++){
            int count = 0;
            ParkingFloor parkingFloor = parkingFloors.get(i);
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()){
                if(parkingSlot.getParkingSlotStatus()==parkingSlotStatus && parkingSlot.getVehicleType()==vehicleType)
                    count++;
            }
            countsHashMap.put(i, count);
        }
        return countsHashMap;
    }

    public HashMap<Integer, List<Integer>> displaySlotsWithGivenStatus(VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus){
        List<ParkingFloor> parkingFloors = this.parkingLot.getParkingFloors();
        HashMap<Integer,List<Integer>> slotsHashMap = new HashMap<>();
        for(int i=0;i<parkingFloors.size();i++) {
            {
                ParkingFloor parkingFloor = parkingFloors.get(i);
                List<Integer> slotsList = new ArrayList<>();
                for (int j = 0; j < parkingFloor.getParkingSlots().size(); j++) {
                    ParkingSlot parkingSlot = parkingFloor.getParkingSlots().get(j);
                    if (parkingSlot.getParkingSlotStatus() == parkingSlotStatus && parkingSlot.getVehicleType() == vehicleType)
                        slotsList.add(j);
                }
                slotsHashMap.put(i, slotsList);
            }
        }
        return slotsHashMap;
    }


    public ParkingLot getParkingLot(){
        return parkingLot;
    }
}
