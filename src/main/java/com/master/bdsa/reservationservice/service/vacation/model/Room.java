package com.master.bdsa.reservationservice.service.vacation.model;

import com.master.bdsa.reservationservice.enums.RoomType;
import lombok.Getter;

@Getter
public class Room {

    private RoomType roomType;
    private Double cost;
}
