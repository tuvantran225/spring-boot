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

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/id")
    public ResponseEntity<Employee> getEmployeeByFirstNameAndLastName(Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/name")
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return employeeService.getEmployeeByFirstNameAndLastName(firstName, lastName);
    }

}
