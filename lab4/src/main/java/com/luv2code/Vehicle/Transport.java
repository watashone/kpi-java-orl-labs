package com.luv2code.Vehicle;

import com.luv2code.Passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport<T extends Passenger> {
    private int maxSeats;
    private List<T> passengers = new ArrayList<>();

    public Transport(int maxSeats) { this.maxSeats = maxSeats; }

    public int getMaxSeats() { return maxSeats; }
    public int getOccupiedSeats() { return passengers.size(); }

    public void boardPassenger(T passenger) throws Exception {
        if (passengers.size() >= maxSeats)
            throw new Exception("No free seats.");
        passengers.add(passenger);
    }

    public void dropPassenger(T passenger) throws Exception {
        if (!passengers.remove(passenger))
            throw new Exception("Passenger not found in vehicle.");
    }

    public List<T> getPassengers() { return passengers; }
}

