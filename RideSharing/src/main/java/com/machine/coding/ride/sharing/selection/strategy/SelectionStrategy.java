package com.machine.coding.ride.sharing.selection.strategy;

import com.machine.coding.ride.sharing.model.Ride;

public interface SelectionStrategy {

    public Ride selectRide(String userId, String origin, String destination, int seats, String preferredVehicleName);

}
