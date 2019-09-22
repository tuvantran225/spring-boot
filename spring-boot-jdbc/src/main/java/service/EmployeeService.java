package service;

import dao.EmployeeDao;
import model.Employee;
import model.ResponseEntity;
import model.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return Optional.ofNullable(employeeDao.getEmployees())
                    .filter(e -> !e.isEmpty())
                    .map(e -> new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), e))
                    .orElse(new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                            "No record found!"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

    public ResponseEntity<Employee> getEmployeeById(Long id) {
        try {
            return Optional.ofNullable(employeeDao.getEmployeeById(id))
                    .map(e -> new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), e))
                    .orElse(new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                            "No record found!"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }

    }

    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return Optional.ofNullable(employeeDao.getEmployeeByFirstNameAndLastName(firstName, lastName))
                    .filter(e -> !e.isEmpty())
                    .map(e -> new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), e))
                    .orElse(new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                            "No record found"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

}
