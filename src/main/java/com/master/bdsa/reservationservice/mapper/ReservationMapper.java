package com.master.bdsa.reservationservice.mapper;

import com.master.bdsa.reservationservice.entity.Reservation;
import com.master.bdsa.reservationservice.reserv.model.ReservationDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface ReservationMapper {

    Reservation reservationDtoToReservation(ReservationDto reservationDto);

    ReservationDto reservationToReservationDto(Reservation reservation);
}
