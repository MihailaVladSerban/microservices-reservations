package com.master.bdsa.reservationservice.service.vacation;

import com.master.bdsa.reservationservice.service.vacation.model.Hotel;
import com.master.bdsa.reservationservice.service.vacation.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VacationServiceFeignClientFailover implements VacationServiceFeignClient {

    private final VacationFailoverFeignClient failoverFeignClient;

    @Override
    public Double calculatePrice(Room room) {
        return failoverFeignClient.calculatePrice(room);
    }

    @Override
    public Double calculatePriceOverNight(Hotel hotel) {
        return failoverFeignClient.calculatePriceOverNight(hotel);
    }
}
