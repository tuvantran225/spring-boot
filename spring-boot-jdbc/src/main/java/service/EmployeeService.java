package service;

import dao.EmployeeProcedureDao;
import dao.EmployeeSqlBuilderDao;
import model.Employee;
import model.EmployeeSearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeProcedureDao employeeDao;
    private final EmployeeSqlBuilderDao employeeSqlBuilderDao;

    public EmployeeService(EmployeeProcedureDao employeeProcedureDao, EmployeeSqlBuilderDao employeeSqlBuilderDao) {
        this.employeeDao = employeeProcedureDao;
        this.employeeSqlBuilderDao = employeeSqlBuilderDao;
    }

    public ResponseEntity getAllEmployeeList() {
        try {
            List<Employee> employees = employeeDao.getAllEmployees();
            return new ResponseEntity(employees, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity getAllEmployeeMap() {
        try {
            List<Employee> employees = employeeDao.getAllEmployees();
            return new ResponseEntity(employees, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity getAllEmployeeError() {
        try {
            List<Employee> employees = employeeDao.getAllEmployeeError();
            return new ResponseEntity(employees, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity getEmployeeByFilter(EmployeeSearchRequest filter) {
        try {
            List<Employee> employees = employeeDao.getEmployeeByFilter(filter);
            return new ResponseEntity(employees, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity getEmployeeById(Long id) {
        try {
            Employee employee = employeeSqlBuilderDao.getEmployeeById(id);
//            ByteArrayInputStream bis = new ByteArrayInputStream(employee.getAttachments());
//            BufferedImage bImage2 = ImageIO.read(bis);
//            ImageIO.write(bImage2, "jpg", new File("attachments.jpg") );
            return new ResponseEntity(employee, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }

    }

    public ResponseEntity createEmployee(Employee employee, MultipartFile attachments) {
        try {
            boolean result = employeeSqlBuilderDao.createEmployee(employee, attachments);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity updateEmployee(Employee employee, Long id) {
        try {
            boolean result = employeeSqlBuilderDao.updateEmployee(employee, id);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
