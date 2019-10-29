package dao;

import mapper.EmployeeProperties;
import mapper.EmployeeRowMapper;
import model.Employee;
import model.EmployeeSearchRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeProcedureDao {

    @Value("${GET_ALL_EMPLOYEES}")
    private String GET_ALL_EMPLOYEES;

    @Value("${GET_ALL_EMPLOYEE_ERROR}")
    private String GET_ALL_EMPLOYEE_ERROR;

    @Value("${GET_EMPLOYEE_BY_ID}")
    private String GET_EMPLOYEE_BY_ID;

    @Value("${GET_EMPLOYEE_BY_FILTER}")
    private String GET_EMPLOYEE_BY_FILTER;

    @Value("${CREATE_EMPLOYEE}")
    private String CREATE_EMPLOYEE;

    private final JdbcTemplate jdbcTemplate;

    public EmployeeProcedureDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees() {
        try {
            return jdbcTemplate.query(GET_ALL_EMPLOYEES, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public List<Employee> getAllEmployeeError() {
        try {
            return jdbcTemplate.query(GET_ALL_EMPLOYEE_ERROR, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public Employee getEmployeeById(Long id) {
        try {
            return jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID, new Long[] {id}, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Employee> getEmployeeByFilter(EmployeeSearchRequest filter) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        HashMap<String, String> params = new HashMap<>();
        params.put(EmployeeProperties.COMPANY.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.LAST_NAME.getPropertyName(), filter.getLastName());
        params.put(EmployeeProperties.FIRST_NAME.getPropertyName(), filter.getFirstName());
        params.put(EmployeeProperties.EMAIL.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.JOB.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.BUSINESS_PHONE.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.HOME_PHONE.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.MOBILE_PHONE.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.FAX.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.ADDRESS.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.CITY.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.STATE.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.ZIP_CODE.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.COUNTRY.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.WEB_PAGE.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.NOTES.getPropertyName(), filter.getCompany());
        params.put(EmployeeProperties.ATTACHMENTS.getPropertyName(), filter.getCompany());
        try {
            return namedParameterJdbcTemplate.query(GET_EMPLOYEE_BY_FILTER, params, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public boolean createEmployee(Employee employee, MultipartFile attachments) throws IOException {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
        HashMap<String, Object> params = new HashMap<>();
        params.put("company", employee.getCompany());
        params.put("lastName", employee.getLastName());
        params.put("firstName", employee.getFirstName());
        params.put("email", employee.getEmail());
        params.put("job", employee.getJob());
        params.put("businessPhone", employee.getBusinessPhone());
        params.put("homePhone", employee.getHomePhone());
        params.put("mobilePhone", employee.getMobilePhone());
        params.put("faxNumber", employee.getFaxNumber());
        params.put("address", employee.getAddress());
        params.put("city", employee.getCity());
        params.put("state", employee.getState());
        params.put("zipCode", employee.getZipCode());
        params.put("country", employee.getCountry());
        params.put("webPage", employee.getWebPage());
        params.put("notes", employee.getNotes());
        params.put("attachments", attachments.getBytes());
        Integer result = jdbcTemplate.update(CREATE_EMPLOYEE, params);
        return Optional.of(result).map(re -> re == 1).orElse(false);
    }
}
