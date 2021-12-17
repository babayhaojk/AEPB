package com.example.AEPB.service;

import com.example.AEPB.model.car.Car;
import com.example.AEPB.model.parking.ParkingLot;
import com.example.AEPB.model.parking.SmartParkingLotBoy;
import com.example.AEPB.model.ticket.CarTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class SmartParkingLotBoyTest {

    private ParkingLot buildParkingLot() {
        Car car1 = Car.builder().carNumberNo("123").build();
        Car car2 = Car.builder().carNumberNo("456").build();
        Car car3 = Car.builder().carNumberNo("789").build();

        List<Car> cars = new ArrayList<>();
        cars.add(0, car1);
        cars.add(1, car2);
        cars.add(2, car3);

        Map<String, Integer> parkingLocation = new HashMap<>();
        parkingLocation.put(car1.getCarNumberNo(), 0);
        parkingLocation.put(car2.getCarNumberNo(), 1);
        parkingLocation.put(car3.getCarNumberNo(), 2);
        ParkingLot parkingLot = ParkingLot.builder().size(3).cars(cars).parkingLocation(
                parkingLocation).build();
        return parkingLot;
    }

    @Test
    void should_part_space_max_when_parkLog_is_not_full() {

        ParkingLot parkingLotMin = buildParkingLot();
        ParkingLot parkingLotMid = buildParkingLot();
        ParkingLot parkingLotMax = buildParkingLot();

        parkingLotMid.pickUp("123");

        parkingLotMax.pickUp("123");
        parkingLotMax.pickUp("456");

        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(
                List.of(parkingLotMin, parkingLotMid, parkingLotMax));
        Car car = Car.builder().carNumberNo("abc").build();
        Optional<CarTicket> ticket = smartParkingLotBoy.park(car);

        assertEquals(2,ticket.get().getParkingLotLocalNo());
        assertEquals(0, parkingLotMax.getParkingLocation().get(ticket.get().getCarNumberNo()));
        assertEquals(car, parkingLotMax.getCars().get(parkingLotMax.getParkingLocation().get(ticket.get().getCarNumberNo())));
    }


    @Test
    void should_park_filed_when_partLog_is_full() {
        ParkingLot parkingLotMin = buildParkingLot();
        ParkingLot parkingLotMid = buildParkingLot();
        ParkingLot parkingLotMax = buildParkingLot();

        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(
                List.of(parkingLotMin, parkingLotMid, parkingLotMax));
        Car car = Car.builder().carNumberNo("abc").build();
        Optional<CarTicket> ticket = smartParkingLotBoy.park(car);

        assertFalse(ticket.isPresent());

    }


}