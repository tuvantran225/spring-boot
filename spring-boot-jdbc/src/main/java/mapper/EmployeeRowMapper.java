package mapper;

import model.Employee;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong(EmployeeProperties.ID.getColumnName());
        String company = rs.getString(EmployeeProperties.COMPANY.getColumnName());
        String lastName = rs.getString(EmployeeProperties.LAST_NAME.getColumnName());
        String firstName = rs.getString(EmployeeProperties.FIRST_NAME.getColumnName());
        String email = rs.getString(EmployeeProperties.EMAIL.getColumnName());
        String job = rs.getString(EmployeeProperties.JOB.getColumnName());
        String businessPhone = rs.getString(EmployeeProperties.BUSINESS_PHONE.getColumnName());
        String homePhone = rs.getString(EmployeeProperties.HOME_PHONE.getColumnName());
        String mobilePhone = rs.getString(EmployeeProperties.MOBILE_PHONE.getColumnName());
        String faxNumber = rs.getString(EmployeeProperties.FAX.getColumnName());
        String address = rs.getString(EmployeeProperties.ADDRESS.getColumnName());
        String city = rs.getString(EmployeeProperties.CITY.getColumnName());
        String state = rs.getString(EmployeeProperties.STATE.getColumnName());
        String zipCode = rs.getString(EmployeeProperties.ZIP_CODE.getColumnName());
        String country = rs.getString(EmployeeProperties.COUNTRY.getColumnName());
        String webPage = rs.getString(EmployeeProperties.WEB_PAGE.getColumnName());
        String notes = rs.getString(EmployeeProperties.NOTES.getColumnName());
        Byte[] attachments = ArrayUtils.toObject(rs.getBytes(EmployeeProperties.ATTACHMENTS.getColumnName()));
        return new Employee(id, company, lastName, firstName, email, job, businessPhone, homePhone,
                mobilePhone, faxNumber, address, city, state, zipCode, country, webPage, notes, attachments);
    }
}
