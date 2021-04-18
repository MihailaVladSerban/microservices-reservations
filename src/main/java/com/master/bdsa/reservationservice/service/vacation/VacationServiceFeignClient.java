package com.master.bdsa.reservationservice.service.vacation;

import com.master.bdsa.reservationservice.config.FeignClientConfig;
import com.master.bdsa.reservationservice.service.vacation.model.Hotel;
import com.master.bdsa.reservationservice.service.vacation.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name="vacation-service", fallback = VacationServiceFeignClientFailover.class, configuration = FeignClientConfig.class)
public interface VacationServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = VacationServiceRestTemplateImpl.ROOM_PATH)
    @ResponseStatus(HttpStatus.OK)
    Double calculatePrice(@RequestParam(value ="room") Room room);

    @RequestMapping(method = RequestMethod.GET, value = VacationServiceRestTemplateImpl.HOTEL_PATH)
    @ResponseStatus(HttpStatus.OK)
    Double calculatePriceOverNight(Hotel hotel);
}
