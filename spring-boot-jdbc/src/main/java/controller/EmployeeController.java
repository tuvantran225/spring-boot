package controller;
import model.Employee;
import model.EmployeeSearchRequest;
import model.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all-employees")
    public ResponseEntity getEmployees() {
        return employeeService.getAllEmployees();
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
