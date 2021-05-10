package com.machine.coding.ride.sharing.service;

import com.machine.coding.ride.sharing.model.Ride;
import com.machine.coding.ride.sharing.model.RideStatus;
import com.machine.coding.ride.sharing.model.User;
import com.machine.coding.ride.sharing.selection.strategy.MostVacantStrategy;
import com.machine.coding.ride.sharing.selection.strategy.PreferredVehicleStrategy;
import com.machine.coding.ride.sharing.selection.strategy.SelectionStrategy;

import java.util.HashMap;
import java.util.List;

public class RideService {

    private HashMap<String, Ride> rides;

    private UserService userService;

    private VehicleService vehicleService;

    private static RideService instance;

    private RideService(){
        this.rides = new HashMap<>();
        this.userService = UserService.getInstance();
        this.vehicleService = VehicleService.getInstance();
    }

    public static RideService getInstance(){
        if(instance == null)
            instance  = new RideService();
        return instance;
    }

    public void offerRide(Ride ride){
        String rideId = ride.getId();
        String offeredBy = ride.getOfferedBy();
        String vehicleId = ride.getVehicleId();
        List<String> offeredRidesByUser = this.userService.getUser(offeredBy).getRidesOffered();
        for(String id : offeredRidesByUser){
            Ride offeredRide = this.rides.get(id);
            if(offeredRide.getVehicleId().equals(vehicleId) && (offeredRide.getStatus()!=RideStatus.COMPLETED)){
                System.out.println("Cannot add ride");
                return;
            }
        }
        this.rides.put(ride.getId(), ride);
        this.userService.getUser(ride.getOfferedBy()).getRidesOffered().add(ride.getId());
    }

    public Ride getRide(String id){
        return this.rides.get(id);
    }

    public HashMap<String, Ride> getRides(){
        return this.rides;
    }

    public void endRide(String rideId){
        this.rides.get(rideId).setStatus(RideStatus.COMPLETED);
    }

    public Ride selectRide(String userId, String origin, String destination, int seats, String preferredVehicleName){

        SelectionStrategy strategy = preferredVehicleName.equals("MOST_VACANT") ? new MostVacantStrategy() : new PreferredVehicleStrategy();
        Ride response  = strategy.selectRide(userId, origin, destination, seats, preferredVehicleName);
        if(response!=null) {
            response.setStatus(RideStatus.ACTIVE);
            this.userService.getUser(userId).getRidesTaken().add(response.getId());
            response.setTakenBy(userId);
        }
        return response;
    }

    public void printRideStats(){
        for(String userId : this.userService.getUsers().keySet()){
            User user = this.userService.getUsers().get(userId);
            List<String> takenRides = user.getRidesTaken();
            int takenRidesCount = 0;
            for(String takenRideId : takenRides){
                if(this.rides.get(takenRideId).getStatus() == RideStatus.COMPLETED)
                    takenRidesCount++;
            }
            List<String> offeredRides = user.getRidesOffered();
            int offeredRidesCount = 0;
            for(String offeredRideId : offeredRides){
                if(this.rides.get(offeredRideId).getStatus() == RideStatus.COMPLETED)
                    offeredRidesCount++;
            }
            System.out.println(user.getName() + " : " + takenRidesCount + " taken, " + offeredRidesCount + " offered.");
        }
    }

}
