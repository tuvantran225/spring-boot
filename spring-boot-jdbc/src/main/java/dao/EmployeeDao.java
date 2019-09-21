package dao;

import mapper.EmployeeRowMapper;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getEmployees() {
        return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());
    }

    public Employee getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        HashMap<String, String> params = new HashMap<>();
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        return namedParameterJdbcTemplate.queryForObject("select * from employees where first_name = :firstName and last_name = :lastName",
                params, new EmployeeRowMapper());
    }

}
