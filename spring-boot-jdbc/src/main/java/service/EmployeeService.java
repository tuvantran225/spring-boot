package service;

import dao.EmployeeDao;
import model.Employee;
import model.ResponseEntity;
import model.ResponseStatus;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), employeeDao.getEmployees());
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

    public ResponseEntity<Employee> getEmployeeById(Long id) {
        try {
            return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), employeeDao.getEmployeeById(id));
        } catch (Exception e) {
            if (e instanceof IncorrectResultSizeDataAccessException) {
                return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                        "No record found");
            }
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), employeeDao.getEmployeeByFirstNameAndLastName(firstName, lastName));
        } catch (Exception e) {
            if (e instanceof IncorrectResultSizeDataAccessException) {
                return new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                        "No record found");
            }
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

}
