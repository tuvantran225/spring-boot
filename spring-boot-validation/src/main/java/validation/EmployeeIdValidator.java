package validation;

import dao.EmployeeSqlBuilderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmployeeIdValidator implements ConstraintValidator<NotExistingEmployeeId, Long> {

    @Autowired
    private EmployeeSqlBuilderDao employeeSqlBuilderDao;

    @Override
    public void initialize(NotExistingEmployeeId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if (id != null) {
            return employeeSqlBuilderDao.getEmployeeById(id) != null;
        }
        return true;
    }
}
