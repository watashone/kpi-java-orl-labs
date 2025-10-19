package com.luv2code;

import com.luv2code.Passenger.Fireman;
import com.luv2code.Passenger.OrdinaryPassenger;
import com.luv2code.Passenger.Policeman;
import com.luv2code.Vehicle.Bus;
import com.luv2code.Vehicle.FireCar;
import com.luv2code.Vehicle.PoliceCar;
import com.luv2code.Vehicle.Taxi;

public class Main {
    public static void main(String[] args) {
        Fireman fireman1 = new Fireman();
        Policeman policeman1 = new Policeman();
        OrdinaryPassenger passenger1 = new OrdinaryPassenger();

        Bus bus = new Bus(5);
        Taxi taxi = new Taxi(3);
        FireCar fireCar = new FireCar(2);
        PoliceCar policeCar = new PoliceCar(2);

        try {
            bus.boardPassenger(fireman1);
            bus.boardPassenger(policeman1);
            bus.boardPassenger(passenger1);

            taxi.boardPassenger(passenger1);
            fireCar.boardPassenger(fireman1);
            policeCar.boardPassenger(policeman1);

            // fireCar.boardPassenger(passenger1); // here will be exception

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        Road road = new Road();
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(fireCar);
        road.addCarToRoad(policeCar);

        System.out.println("Total number of people on the road: " + road.getCountOfHumans());
    }
}
