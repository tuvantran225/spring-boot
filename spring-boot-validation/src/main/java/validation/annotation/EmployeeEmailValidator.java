package validation.annotation;

import dao.EmployeeSqlBuilderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmployeeEmailValidator implements ConstraintValidator<DuplicatedEmployeeEmail, String> {

    @Autowired
    private EmployeeSqlBuilderDao employeeSqlBuilderDao;

    @Override
    public void initialize(DuplicatedEmployeeEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email != null) {
            return employeeSqlBuilderDao.getEmployeeByEmail(email) == null;
        }
        return true;
    }
}
