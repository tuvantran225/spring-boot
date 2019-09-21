package mapper;

import model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String company = rs.getString("company");
        String lastName = rs.getString("last_name");
        String firstName = rs.getString("first_name");
        String email = rs.getString("email_address");
        String job = rs.getString("job_title");
        String businessPhone = rs.getString("business_phone");
        String homePhone = rs.getString("home_phone");
        String mobilePhone = rs.getString("mobile_phone");
        String faxNumber = rs.getString("fax_number");
        String address = rs.getString("address");
        String city = rs.getString("city");
        String state = rs.getString("state_province");
        String zipCode = rs.getString("zip_postal_code");
        String country = rs.getString("country_region");
        String webPage = rs.getString("web_page");
        String notes = rs.getString("notes");
        Byte attachments = rs.getByte("attachments");
        return new Employee(id, company, lastName, firstName, email, job, businessPhone, homePhone,
                mobilePhone, faxNumber, address, city, state, zipCode, country, webPage, notes, attachments);
    }
}
