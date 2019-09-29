package dao;

import constant.EmloyeeConstant;
import mapper.EmployeeProperties;
import mapper.EmployeeRowMapper;
import model.Employee;
import model.EmployeeSearchRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import sqlbuilder.SqlBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static sqlbuilder.SqlBuilder.and;
import static sqlbuilder.SqlBuilder.equal;

@Repository
public class EmployeeSqlBuilderDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeSqlBuilderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getEmployees(EmployeeSearchRequest filter) {
        SqlBuilder sqlBuilder = new SqlBuilder();
        String query = sqlBuilder
                .from(EmloyeeConstant.EMPLOYEE_TABLE + " e " +
                        "LEFT JOIN " + EmloyeeConstant.EMPLOYEE_PRIVILEGE_TABLE + " ep ON e.id = ep.employee_id" )
                .where(
                        and(
                                equal(EmployeeProperties.COMPANY.getColumnName(), filter.getCompany()),
                                equal(EmployeeProperties.FIRST_NAME.getColumnName(), filter.getFirstName()),
                                equal(EmployeeProperties.LAST_NAME.getColumnName(), filter.getLastName()),
                                equal("ep.privilege_id", filter.getPrivilegeId())
                        )
                )
                .toSql();
        try {
            return jdbcTemplate.query(query, sqlBuilder.getQueryParameterValues().toArray(), new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public Employee getEmployeeById(Long id) {
        SqlBuilder sqlBuilder = new SqlBuilder(EmloyeeConstant.EMPLOYEE_TABLE);
        String query = sqlBuilder
                .where(
                        equal(EmployeeProperties.ID.getColumnName(), id)
                )
                .toSql();
        try {
            return jdbcTemplate.queryForObject(query, sqlBuilder.getQueryParameterValues().toArray(), new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public boolean createEmployee(Employee employee, MultipartFile attachments) throws IOException, IllegalAccessException {
        HashMap<String, Object> params = new HashMap<>();
        for (int i = 1; i < EmployeeProperties.values().length; i++) {
            params.put(EmployeeProperties.values()[i].getColumnName(), Employee.class.getDeclaredFields()[i].get(employee));
        }
        if (attachments != null) {
            params.put(EmployeeProperties.ATTACHMENTS.getColumnName(), attachments.getBytes());
        }
        SqlBuilder sqlBuilder = new SqlBuilder(EmloyeeConstant.EMPLOYEE_TABLE);
        String query = sqlBuilder
                .insert(params)
                .toSql();
        Integer result = jdbcTemplate.update(query, sqlBuilder.getQueryParameterValues().toArray());
        return Optional.of(result).map(re -> re == 1).orElse(false);
    }

    public boolean updateEmployee(Employee employee, Long id) throws IllegalAccessException {
        HashMap<String, Object> params = new HashMap<>();
        for (int i = 1; i < EmployeeProperties.values().length; i++) {
            params.put(EmployeeProperties.values()[i].getColumnName(), Employee.class.getDeclaredFields()[i].get(employee));
        }
        SqlBuilder sqlBuilder = new SqlBuilder(EmloyeeConstant.EMPLOYEE_TABLE);
        String query = sqlBuilder
                .update(params)
                .where(
                        equal(EmployeeProperties.ID.getColumnName(), id)
                )
                .toSql();
        Integer result = jdbcTemplate.update(query, sqlBuilder.getQueryParameterValues().toArray());
        return Optional.of(result).map(re -> re == 1).orElse(false);
    }
}
