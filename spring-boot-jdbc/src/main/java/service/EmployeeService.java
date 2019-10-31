package service;

import dao.EmployeeProcedureDao;
import dao.EmployeeSqlBuilderDao;
import http.ErrorResponse;
import http.Response;
import http.Status;
import http.SuccessResponse;
import model.Employee;
import model.EmployeeSearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeProcedureDao employeeDao;
    private final EmployeeSqlBuilderDao employeeSqlBuilderDao;

    public EmployeeService(EmployeeProcedureDao employeeProcedureDao, EmployeeSqlBuilderDao employeeSqlBuilderDao) {
        this.employeeDao = employeeProcedureDao;
        this.employeeSqlBuilderDao = employeeSqlBuilderDao;
    }

    public Response getAllEmployeeList() {
        try {
            List<Employee> employees = employeeDao.getAllEmployees();
            return new SuccessResponse(Status.SUCCESS.getCode(), employees);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponse(Status.INTERNAL_SERVER_ERROR.getCode(), Status.INTERNAL_SERVER_ERROR.getDesc());
        }
    }

    public ResponseEntity getAllEmployeeMap() {
        try {
            List<Employee> employees = employeeDao.getAllEmployees();
            return new ResponseEntity(employees, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Response getAllEmployeeError() {
        try {
            List<Employee> employees = employeeDao.getAllEmployeeError();
            return new SuccessResponse(Status.SUCCESS.getCode(), employees);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponse(Status.INTERNAL_SERVER_ERROR.getCode(), Status.INTERNAL_SERVER_ERROR.getDesc());
        }
    }

    public ResponseEntity getEmployeeByFilter(EmployeeSearchRequest filter) {
        try {
            List<Employee> employees = employeeDao.getEmployeeByFilter(filter);
            return new ResponseEntity(employees, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
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
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity createEmployee(Employee employee, MultipartFile attachments) {
        try {
            boolean result = employeeSqlBuilderDao.createEmployee(employee, attachments);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity updateEmployee(Employee employee, Long id) {
        try {
            boolean result = employeeSqlBuilderDao.updateEmployee(employee, id);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
