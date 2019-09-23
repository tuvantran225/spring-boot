package service;

import dao.EmployeeDao;
import model.Employee;
import model.ResponseEntity;
import model.ResponseStatus;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return Optional.ofNullable(employeeDao.getEmployees())
                    .filter(e -> !e.isEmpty())
                    .map(e -> new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(),
                            ResponseStatus.SUCCESS.getError(),
                            ResponseStatus.SUCCESS.getError(), e))
                    .orElse(new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                            "No record found!"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

    public ResponseEntity<Employee> getEmployeeById(Long id) {
        Employee employee = null;
        try {
            employee = employeeDao.getEmployeeById(id);
            ByteArrayInputStream bis = new ByteArrayInputStream(employee.getAttachments());
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "jpg", new File("attachments.jpg") );
            return Optional.ofNullable(employee)
                    .map(e -> new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(),
                            ResponseStatus.SUCCESS.getError(),
                            ResponseStatus.SUCCESS.getError(), e))
                    .orElse(new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                            "No record found!"));
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return Optional.ofNullable(employee)
                        .map(emp -> new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(),
                                ResponseStatus.SUCCESS.getError(),
                                ResponseStatus.SUCCESS.getError(), emp))
                        .orElse(new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                                "No record found!"));
            }
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }

    }

    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return Optional.ofNullable(employeeDao.getEmployeeByFirstNameAndLastName(firstName, lastName))
                    .filter(e -> !e.isEmpty())
                    .map(e -> new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), e))
                    .orElse(new ResponseEntity<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getError(),
                            "No record found"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getError(), e.getMessage());
        }
    }

    public boolean createEmployee(Employee employee, MultipartFile attachments) throws IOException {
        return employeeDao.createEmployee(employee, attachments);
    }
}
