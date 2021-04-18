package com.master.bdsa.reservationservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.master.bdsa.reservationservice.enums.Facility;
import com.master.bdsa.reservationservice.enums.RoomType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation extends BaseEntity {

    @Builder
    public Reservation(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                       UUID roomUuid, UUID hotelUuid, LocalDate checkIn, LocalDate checkOut, Facility facility, RoomType roomType,
                       Boolean reservationActive) {
        super(id, version, createdDate, lastModifiedDate);
        this.hotelUuid = hotelUuid;
        this.roomUuid = roomUuid;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.facility = facility;
        this.roomType = roomType;
        this.reservationActive = reservationActive;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate checkIn;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate checkOut;


    private UUID hotelUuid;
    private UUID roomUuid;
    private RoomType roomType;
    private Facility facility;

    @Column(name = "reservationActive", nullable = false)
    private boolean reservationActive;
}
