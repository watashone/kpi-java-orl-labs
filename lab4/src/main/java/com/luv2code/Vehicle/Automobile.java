package com.luv2code.Vehicle;

import com.luv2code.Passenger.Passenger;

public abstract class Automobile<T extends Passenger> extends Transport<T> {
    public Automobile(int maxSeats) { super(maxSeats); }
}
