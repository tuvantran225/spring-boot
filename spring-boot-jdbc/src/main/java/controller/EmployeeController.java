package controller;
import model.Employee;
import model.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/name")
    public ResponseEntity<Employee> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return employeeService.getEmployeeByFirstNameAndLastName(firstName, lastName);
    }

}
