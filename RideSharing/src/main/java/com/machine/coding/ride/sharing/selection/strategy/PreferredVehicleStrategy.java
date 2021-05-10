package com.machine.coding.ride.sharing.selection.strategy;

import com.machine.coding.ride.sharing.model.Ride;
import com.machine.coding.ride.sharing.service.RideService;
import com.machine.coding.ride.sharing.service.VehicleService;

import java.util.HashMap;
import java.util.Map;

public class PreferredVehicleStrategy implements SelectionStrategy{

    private RideService rideService;

    private VehicleService vehicleService;

    public PreferredVehicleStrategy(){
        this.rideService = RideService.getInstance();
        this.vehicleService = VehicleService.getInstance();
    }


    @Override
    public Ride selectRide(String userId, String origin, String destination, int seats, String preferredVehicleName) {
        HashMap<String, Ride> rides = rideService.getRides();
        for(Map.Entry<String, Ride> entry : rides.entrySet()){
            String rideId = entry.getKey();
            Ride ride = entry.getValue();
            if(ride.getOrigin().equals(origin) && ride.getDestination().equals(destination) && ride.getAvailableSeats()>=seats){
                if(this.vehicleService.getVehicles().get(ride.getVehicleId()).getName().equals(preferredVehicleName))
                {
                    return ride;
                }
            }
        }
        return null;
    }
}
