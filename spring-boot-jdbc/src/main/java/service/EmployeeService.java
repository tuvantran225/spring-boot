package service;

import dao.EmployeeProcedureDao;
import dao.EmployeeSqlBuilderDao;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
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

    public ResponseEntity getEmployees(EmployeeSearchRequest filter) {
        try {
            List<Employee> employees = employeeSqlBuilderDao.getEmployees(filter);
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), employees);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }
    }

    public ResponseEntity getEmployeeById(Long id) {
        try {
            Employee employee = employeeSqlBuilderDao.getEmployeeById(id);
//            ByteArrayInputStream bis = new ByteArrayInputStream(employee.getAttachments());
//            BufferedImage bImage2 = ImageIO.read(bis);
//            ImageIO.write(bImage2, "jpg", new File("attachments.jpg") );
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), employee);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }

    }

    public ResponseEntity createEmployee(Employee employee, MultipartFile attachments) {
        try {
            boolean result = employeeSqlBuilderDao.createEmployee(employee, attachments);
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), result);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }
    }

    public ResponseEntity updateEmployee(Employee employee, Long id) {
        try {
            boolean result = employeeSqlBuilderDao.updateEmployee(employee, id);
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), result);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }
    }
}
