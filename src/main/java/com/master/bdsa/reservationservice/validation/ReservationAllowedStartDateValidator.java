package com.master.bdsa.reservationservice.validation;

import com.master.bdsa.reservationservice.reserv.model.ReservationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ReservationAllowedStartDateValidator implements ConstraintValidator<ReservationAllowedStartDate, ReservationDto> {
    @Override
    public void initialize(ReservationAllowedStartDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(ReservationDto reservationDto, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().isBefore(reservationDto.getCheckIn())
                && reservationDto.getCheckIn().isBefore(LocalDate.now().plusMonths(1).plusDays(1));
    }
}
