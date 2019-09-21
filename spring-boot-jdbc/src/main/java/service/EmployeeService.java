package service;

import dao.EmployeeDao;
import model.Employee;
import model.ResponseEntity;
import model.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), employeeDao.getEmployees());
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

    public ResponseEntity<Employee> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), employeeDao.getEmployeeByFirstNameAndLastName(firstName, lastName));
        } catch (Exception e) {
            if (e instanceof IncorrectResultSizeDataAccessException) {
                return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), null);
            }
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

}
