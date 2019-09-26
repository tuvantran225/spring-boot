package controller;
import model.Employee;
import model.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.EmployeeService;

import javax.validation.Valid;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployeeByFirstNameAndLastName(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/name")
    public ResponseEntity getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return employeeService.getEmployeeByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping("/employees")
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee, MultipartFile attachments) {
        return employeeService.createEmployee(employee, attachments);
    }

}
