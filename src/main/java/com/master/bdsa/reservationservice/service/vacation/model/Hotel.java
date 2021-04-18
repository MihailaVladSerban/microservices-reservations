package com.master.bdsa.reservationservice.service.vacation.model;

import com.master.bdsa.reservationservice.enums.Facility;
import lombok.Getter;

@Getter
public class Hotel {

    private Facility facility;
    private Double priceOverNight;
}
