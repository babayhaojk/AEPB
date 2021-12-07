package com.example.AEPB.service;
import com.example.AEPB.MultipleParkingLog;
import com.example.AEPB.MultipleParkingLog.MultipleParkingLogBuilder;
import com.example.AEPB.ParkLot;
import com.example.AEPB.ParkSpace;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MultipleParkingLotTest {
    @Autowired
    private MultipleParkingLotService multipleParkingLotService;

    @Test
    public void should_parking_lot_success_when_parking_space_order_and_parking_lot_order() {
        // given
        ParkSpace parkSpace = ParkSpace.builder().parkingSpaceNumber(1).isHaveCar(true).build();
        ParkLot parkLot = ParkLot.builder().parkSpace(parkSpace).numberOfParkLog(100).remainNumber(2).build();
        MultipleParkingLog multipleParkingLogBuilder = MultipleParkingLog.builder().parkingLogNumber(1)
                .parkingLogCount(10).parkLot(parkLot).build();
        // when
       boolean isResult =  multipleParkingLotService.getparkingLot(multipleParkingLogBuilder);

       // then
        Assert.assertTrue(isResult);
    }
}
