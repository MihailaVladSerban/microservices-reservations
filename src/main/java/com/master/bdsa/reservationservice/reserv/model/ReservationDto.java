package com.master.bdsa.reservationservice.reserv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.master.bdsa.reservationservice.enums.Facility;
import com.master.bdsa.reservationservice.enums.RoomType;
import com.master.bdsa.reservationservice.validation.ReservationAllowedStartDate;
import com.master.bdsa.reservationservice.validation.ReservationMaximumStay;
import com.master.bdsa.reservationservice.validation.ReservationStartDateBeforeEndDate;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ReservationStartDateBeforeEndDate
@ReservationAllowedStartDate
@ReservationMaximumStay
public class ReservationDto {

    private UUID hotelUuid;
    private UUID roomUuid;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    private Integer version;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull
    @Future(message = "Reservation start date must be a future date")
    private LocalDate checkIn;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull
    @Future(message = "Reservation end date must be a future date")
    private LocalDate checkOut;

    private RoomType roomType;
    private Facility facility;
    private boolean reservationActive;


}
