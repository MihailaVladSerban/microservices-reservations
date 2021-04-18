package com.master.bdsa.reservationservice.service;

import com.master.bdsa.reservationservice.reserv.model.ReservationDto;
import com.master.bdsa.reservationservice.entity.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public interface ReservationService {

    ReservationDto getReservationById(UUID reservationUuid);

    ReservationDto updateReservation(UUID reservationUuid, ReservationDto reservationDto);

    Reservation saveReservation(ReservationDto reservationDto);

    boolean cancelReservation(UUID reservationUuid);

    List<ReservationDto> getByReservationsBetweenDates(LocalDate fromStartDate, LocalDate toEndDate);
}
