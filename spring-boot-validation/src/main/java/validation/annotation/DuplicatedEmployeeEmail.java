package validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeEmailValidator.class)
@Documented
public @interface DuplicatedEmployeeEmail {

    String message() default "Email is duplicated";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
