package mapper;

public enum EmployeeProperties {

    ID("id", "Id", "id"),
    COMPANY("company", "Company", "company"),
    LAST_NAME("lastName", "Last name", "last_name"),
    FIRST_NAME("firstName", "First name", "first_name"),
    EMAIL("email", "Email", "email_address"),
    JOB("job", "Job", "job_title"),
    BUSINESS_PHONE("businessPhone", "Business phone", "business_phone"),
    HOME_PHONE("homePhone", "Home phone", "home_phone"),
    MOBILE_PHONE("mobilePhone", "Mobile phone", "mobile_phone"),
    FAX("faxNumber", "Fax number", "fax_number"),
    ADDRESS("address", "Address", "address"),
    CITY("city", "City", "city"),
    STATE("state", "State Province", "state_province"),
    ZIP_CODE("zipCode", "Zip postal code", "zip_postal_code"),
    COUNTRY("country", "Country", "country_region"),
    WEB_PAGE("webPage", "Web page", "web_page"),
    NOTES("notes", "Notes", "notes"),
    ATTACHMENTS("attachments", "Attachments", "attachments");

    private String propertyName;
    private String fieldName;
    private String columnName;

    EmployeeProperties(String propertyName, String fieldName, String columnName) {
        this.propertyName = propertyName;
        this.fieldName = fieldName;
        this.columnName = columnName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getColumnName() {
        return columnName;
    }
}
