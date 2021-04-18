package com.master.bdsa.reservationservice.repository;

import com.master.bdsa.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    List<Reservation> findByCheckInGreaterThanEqualAndCheckOutLessThanEqual(LocalDate fromStartDate, LocalDate toEndDate);


}
