package com.master.bdsa.reservationservice.validation;

import com.master.bdsa.reservationservice.reserv.model.ReservationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReservationStartDateBeforeEndDateValidator implements ConstraintValidator<ReservationStartDateBeforeEndDate, ReservationDto> {
    @Override
    public void initialize(ReservationStartDateBeforeEndDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(ReservationDto reservationDto, ConstraintValidatorContext constraintValidatorContext) {
        return reservationDto.getCheckIn().isBefore(reservationDto.getCheckOut());
    }
}
