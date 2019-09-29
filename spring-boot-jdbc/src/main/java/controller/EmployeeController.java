package controller;
import model.Employee;
import model.EmployeeSearchRequest;
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
    public ResponseEntity getEmployees(EmployeeSearchRequest filter) {
        return employeeService.getEmployees(filter);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee, MultipartFile attachments) {
        return employeeService.createEmployee(employee, attachments);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@Valid @RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }

}
