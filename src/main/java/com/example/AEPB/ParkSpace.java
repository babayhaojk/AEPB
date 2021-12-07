package com.example.AEPB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ParkSpace {
    // 停车位号
    private int parkingSpaceNumber;

    // 是否已经停车
    private boolean isHaveCar;
}
