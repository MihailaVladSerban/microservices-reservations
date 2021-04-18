package com.master.bdsa.reservationservice.service.vacation;

import com.master.bdsa.reservationservice.service.vacation.model.Hotel;
import com.master.bdsa.reservationservice.service.vacation.model.Room;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Profile("local-dev")
@Service
public class VacationServiceFeign implements VacationService {

    private final VacationServiceFeignClient vacationServiceFeignClient;
    @Override
    public Double calculatePrice(Room room) {
        return vacationServiceFeignClient.calculatePrice(room);
    }

    @Override
    public Double calculatePriceOverNight(Hotel hotel) {
        return vacationServiceFeignClient.calculatePriceOverNight(hotel);
    }
}
