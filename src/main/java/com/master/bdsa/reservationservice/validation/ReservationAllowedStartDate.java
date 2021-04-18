package com.master.bdsa.reservationservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ReservationAllowedStartDateValidator.class})
@Documented
public @interface ReservationAllowedStartDate {

    String message() default "Reservation start date must be from 1 day to up to 1 month ahead";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
