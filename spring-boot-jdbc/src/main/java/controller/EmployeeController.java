package controller;
import http.Response;
import model.Employee;
import model.EmployeeSearchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all-employee-list")
    public Response getAllEmployeeList() {
        return employeeService.getAllEmployeeList();
    }

    @GetMapping("/all-employee-map")
    public ResponseEntity getAllEmployeeMap() {
        return employeeService.getAllEmployeeMap();
    }

    @GetMapping("/all-employee-error")
    public Response getAllEmployeeError() {
        return employeeService.getAllEmployeeError();
    }

    @GetMapping("/employees")
    public ResponseEntity getEmployees(EmployeeSearchRequest filter) {
        return employeeService.getEmployeeByFilter(filter);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity createEmployee(Employee employee, MultipartFile attachments) {
        return employeeService.createEmployee(employee, attachments);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }

}
