package com.master.bdsa.reservationservice.reserv.model;

import com.master.bdsa.reservationservice.enums.Facility;
import com.master.bdsa.reservationservice.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {


    private UUID reservationUuid;
    private UUID hotelUuid;
    private UUID roomUuid;
    private RoomType roomType;
    private Facility facility;

}
