package com.example.AEPB;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ParkLot {
    // 停车位
    private ParkSpace parkSpace;

    // 停车位数
    private int numberOfParkLog;

    // 剩余停车位
    private int remainNumber;


    public boolean hasParkSpace() {
        return remainNumber > 0 && remainNumber < numberOfParkLog;
    }

    public boolean hasGetPark() {
        return remainNumber < numberOfParkLog;
    }

    public boolean hasGetParkFailed() {
        return remainNumber == 0;
    }
}
