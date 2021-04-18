package com.master.bdsa.reservationservice.validation;

import com.master.bdsa.reservationservice.reserv.model.ReservationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Period;

public class ReservationMaximumStayValidator implements ConstraintValidator <ReservationMaximumStay, ReservationDto> {
    @Override
    public void initialize(ReservationMaximumStay constraintAnnotation) {

    }

    @Override
    public boolean isValid(ReservationDto reservationDto, ConstraintValidatorContext constraintValidatorContext) {
        return Period.between(reservationDto.getCheckIn(), reservationDto.getCheckOut()).getDays() <= 5;
    }
}
