package controller;
import model.Employee;
import model.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.EmployeeService;

import java.io.IOException;
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

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeByFirstNameAndLastName(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/name")
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return employeeService.getEmployeeByFirstNameAndLastName(firstName, lastName);
    }

    @PutMapping("/employees")
    public boolean createEmployee(Employee employee, MultipartFile attachments) throws IOException {
        return employeeService.createEmployee(employee, attachments);
    }

}
