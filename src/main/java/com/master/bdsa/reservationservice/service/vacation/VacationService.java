package com.master.bdsa.reservationservice.service.vacation;

import com.master.bdsa.reservationservice.service.vacation.model.Hotel;
import com.master.bdsa.reservationservice.service.vacation.model.Room;

public interface VacationService {

    Double calculatePrice(Room room);

    Double calculatePriceOverNight(Hotel hotel);
}
