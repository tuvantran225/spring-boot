package dao;

import mapper.EmployeeRowMapper;
import model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
public class EmployeeDao {

    @Value("${GET_ALL_EMPLOYEES}")
    private String GET_ALL_EMPLOYEES;

    @Value("${GET_EMPLOYEE_BY_ID}")
    private String GET_EMPLOYEE_BY_ID;

    @Value("${GET_EMPLOYEE_BY_FIRST_NAME_AND_LAST_NAME}")
    private String GET_EMPLOYEE_BY_FIRST_NAME_AND_LAST_NAME;

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getEmployees() {
        try {
            return jdbcTemplate.query(GET_ALL_EMPLOYEES, new EmployeeRowMapper());
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

    public List<Employee> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        HashMap<String, String> params = new HashMap<>();
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        try {
            return namedParameterJdbcTemplate.query(GET_EMPLOYEE_BY_FIRST_NAME_AND_LAST_NAME, params, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
