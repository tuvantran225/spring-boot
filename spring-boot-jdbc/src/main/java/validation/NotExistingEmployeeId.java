package validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeIdValidator.class)
@Documented
public @interface NotExistingEmployeeId {

    String message() default "Employee id does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
