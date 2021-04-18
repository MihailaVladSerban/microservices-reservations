package com.master.bdsa.reservationservice.controller;

import com.master.bdsa.reservationservice.config.RabbitmqConfig;
import com.master.bdsa.reservationservice.reserv.model.ReservationDto;
import com.master.bdsa.reservationservice.service.ReservationService;
import com.master.bdsa.reservationservice.entity.Reservation;
import com.master.bdsa.reservationservice.reserv.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("api/v1/reservation")
@RestController
public class ReservationController {

    private final ReservationService reservationService;
    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/findReservationsBetweenDates")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationDto> findReservationsBetweenDates(@RequestParam(value = "fromStartDate")
                                                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromStartDate,
                                                             @RequestParam(value = "toEndDate")
                                                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toEndDate) {
        return reservationService.getByReservationsBetweenDates(fromStartDate, toEndDate);
    }


    @GetMapping("/{reservationUuid}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDto findReservationById(@PathVariable("reservationUuid") UUID reservationUuid) {
        return reservationService.getReservationById(reservationUuid);
    }

    @PutMapping("/{reservationUuid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReservationDto updateReservationById(@PathVariable("reservationUuid") UUID reservationUuid, @RequestBody @Valid ReservationDto reservationDto) {
        return reservationService.updateReservation(reservationUuid, reservationDto);

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody @Valid ReservationDto reservationDto) {
        return reservationService.saveReservation(reservationDto);

    }

    @PostMapping("/sendOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody @Valid OrderDto orderDto) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY, orderDto);
    }

    @DeleteMapping("/{reservationUuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelReservation(@PathVariable("reservationUuid") UUID reservationUuid) {
        reservationService.cancelReservation(reservationUuid);
    }
}
