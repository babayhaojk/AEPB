package com.example.AEPB.model.parking;

import com.example.AEPB.model.car.Car;
import com.example.AEPB.model.ticket.CarTicket;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SmartParkingLotBoy extends ParkingBoy {

    private List<ParkingLot> parkingLotList;

    @Override
    public Optional<CarTicket> park(Car car){
        CarTicket carTicket = new CarTicket();
        Optional<ParkingLot> parkingLot = parkingLotList.stream().max(
                Comparator.comparingInt(ParkingLot::getRemainingCapacity));

        if (parkingLot.isEmpty()){
            return Optional.empty();
        }
        Optional<String> plateNumber = parkingLot.get().park(car);
        if (plateNumber.isEmpty()){
            return Optional.empty();
        }
        int index = parkingLotList.indexOf(parkingLot.get());
        carTicket.setParkingLotLocalNo(index);
        carTicket.setCarNumberNo(plateNumber.get());
        return Optional.of(carTicket);
    }

    @Override
    public Car pickUp(CarTicket carTicket){
        return parkingLotList.get(carTicket.getParkingLotLocalNo()).pickUp(carTicket.getCarNumberNo());
    }
}
