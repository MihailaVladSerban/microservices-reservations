package com.master.bdsa.reservationservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ReservationMaximumStayValidator.class})
@Documented
public @interface ReservationMaximumStay {

    String message() default "Reservation stay length must be less or equal to five days";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

