package com.master.bdsa.reservationservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ReservationStartDateBeforeEndDateValidator.class})
@Documented
public @interface ReservationStartDateBeforeEndDate {

    String message() default "Reservation start date must be before end date";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
