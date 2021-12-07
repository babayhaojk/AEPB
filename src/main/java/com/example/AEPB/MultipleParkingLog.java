package com.example.AEPB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MultipleParkingLog {
    // 停车场序号
    private int parkingLogNumber;

    // 停车场
    private ParkLot parkLot;

    // 停车场数量
    private int parkingLogCount;

    // 停车场剩余数量
    private int remainCount;
}
