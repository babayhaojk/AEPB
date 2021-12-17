package com.example.AEPB.model.parking;

import com.example.AEPB.model.car.Car;
import com.example.AEPB.model.ticket.CarTicket;

import java.util.Optional;

public abstract class ParkingBoy {

    abstract Optional<CarTicket> park(Car car);

    abstract Car pickUp(CarTicket carTicket);
}
