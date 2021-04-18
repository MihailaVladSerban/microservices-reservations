package com.master.bdsa.reservationservice.service;

import com.master.bdsa.reservationservice.reserv.model.ReservationDto;
import com.master.bdsa.reservationservice.entity.Reservation;
import com.master.bdsa.reservationservice.exception.ReservationNotFoundException;
import com.master.bdsa.reservationservice.mapper.ReservationMapper;
import com.master.bdsa.reservationservice.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Log4j2
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationrepository;
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationDto getReservationById(UUID reservationUuid) {
        Reservation reservation = reservationrepository.findById(reservationUuid)
                .orElseThrow(() -> new ReservationNotFoundException("No reservation found with UUID: " + reservationUuid));
        log.debug("reservation with UUID :" + reservationUuid);
        return reservationMapper.reservationToReservationDto(reservation);
    }

    @Override
    public ReservationDto updateReservation(UUID reservationUuid, ReservationDto reservationDto) {
        Reservation reservation = reservationrepository.findById(reservationUuid)
                .orElseThrow(() -> new ReservationNotFoundException("No reservation found with UUID: " + reservationUuid));
        reservation.setCheckIn(reservationDto.getCheckIn());
        reservation.setCheckOut(reservationDto.getCheckOut());
        reservation.setReservationActive(true);
        return reservationMapper.reservationToReservationDto(reservationrepository.save(reservation));
    }

    @Override
    public Reservation saveReservation(ReservationDto reservationDto) {
        Reservation savedReservation = reservationMapper.reservationDtoToReservation(reservationDto);
        savedReservation.setReservationActive(true);
        return reservationrepository.save(savedReservation);
    }

    @Override
    public boolean cancelReservation(UUID reservationUuid) {

        Reservation reservation = reservationrepository.findById(reservationUuid)
                .orElseThrow(() -> new ReservationNotFoundException("No reservation found with UUID: " + reservationUuid));
        reservation.setReservationActive(false);
        reservationrepository.save(reservation);
        return !reservation.isReservationActive();
    }

    @Override
    public List<ReservationDto> getByReservationsBetweenDates(LocalDate fromStartDate, LocalDate toEndDate) {
        List<Reservation> reservationList = reservationrepository.findByCheckInGreaterThanEqualAndCheckOutLessThanEqual(fromStartDate, toEndDate);
        return reservationList.stream().map(reservationMapper::reservationToReservationDto).collect(Collectors.toList());
    }
}

