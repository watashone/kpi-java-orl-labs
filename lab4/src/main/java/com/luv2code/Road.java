package com.luv2code;

import com.luv2code.Passenger.Passenger;
import com.luv2code.Vehicle.Transport;

import java.util.*;

public class Road {
    public List<Transport<? extends Passenger>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int count = 0;
        for (Transport<? extends Passenger> car : carsInRoad) {
            count += car.getOccupiedSeats();
        }
        return count;
    }

    public void addCarToRoad(Transport<? extends Passenger> car) {
        carsInRoad.add(car);
    }
}

