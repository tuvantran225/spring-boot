package service;

import dao.EmployeeDao;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ResponseEntity getEmployees() {
        try {
            List<Employee> employees = employeeDao.getEmployees();
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), employees);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }
    }

    public ResponseEntity getEmployeeById(Long id) {
        try {
            Employee employee = employeeDao.getEmployeeById(id);
            ByteArrayInputStream bis = new ByteArrayInputStream(employee.getAttachments());
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "jpg", new File("attachments.jpg") );
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), employee);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }

    }

    public ResponseEntity getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        try {
            List<Employee> employees = employeeDao.getEmployeeByFirstNameAndLastName(firstName, lastName);
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), employees);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }
    }

    public ResponseEntity createEmployee(Employee employee, MultipartFile attachments) {
        try {
            boolean result = employeeDao.createEmployee(employee, attachments);
            return new SuccessResponseEntity(ResponseStatus.SUCCESS.getCode(), result);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ErrorResponseEntity(ResponseStatus.ERROR.getCode(), Arrays.asList(e.toString()));
        }
    }
}
