package com.master.bdsa.reservationservice.service.vacation;

import com.master.bdsa.reservationservice.service.vacation.model.Hotel;
import com.master.bdsa.reservationservice.service.vacation.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "vacation-failover")
public interface VacationFailoverFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/vacation-failover")
    @ResponseStatus(HttpStatus.OK)
    Double calculatePrice(@RequestParam(value ="room") Room room);

    @RequestMapping(method = RequestMethod.GET, value = "/vacation-failover")
    @ResponseStatus(HttpStatus.OK)
    Double calculatePriceOverNight(Hotel hotel);



}
