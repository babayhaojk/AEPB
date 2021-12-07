package com.example.AEPB.service;

import com.example.AEPB.ParkLot;
import com.example.AEPB.ParkSpace;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ParkLotServiceTest {

    @Test
    public void should_parking_lot_given_park_space_success() {
        // given
        ParkLot parkLot = new ParkLot(ParkSpace.builder().parkingSpaceNumber(1).isHaveCar(true).build(), 10, 5);

        // then
        Assert.assertTrue(parkLot.hasParkSpace());
    }


    @Test
    public void should_get_parking_success_is_not_space() {
        // given
        ParkLot parkLot = new ParkLot(ParkSpace.builder().parkingSpaceNumber(2).isHaveCar(true).build(), 10, 5);

        // then
        Assert.assertTrue(parkLot.hasGetPark());

    }

    @Test
    public void should_get_parking_failed_is_empty() {
        // given
        ParkLot parkLot = new ParkLot(ParkSpace.builder().parkingSpaceNumber(3).isHaveCar(true).build(), 10, 0);

        // then
        Assert.assertTrue(parkLot.hasGetParkFailed());
    }

}
