package mapper;

public enum EmployeeProperties {

    ID("Id", "id"),
    COMPANY("Company", "company"),
    LAST_NAME("Last name", "last_name"),
    FIRST_NAME("First name", "first_name"),
    EMAIL("Email", "email_address"),
    JOB("Job", "job_title"),
    BUSINESS_PHONE("Business phone", "business_phone"),
    HOME_PHONE("Home phone", "home_phone"),
    MOBILE_PHONE("Mobile phone", "mobile_phone"),
    FAX("Fax", "fax_number"),
    ADDRESS("Address", "address"),
    CITY("City", "city"),
    STATE("State", "state_province"),
    ZIP_CODE("Zip code", "zip_postal_code"),
    COUNTRY("Country", "country_region"),
    WEB_PAGE("Web page", "web_page"),
    NOTES("Notes", "notes"),
    ATTACHMENTS("Attachments", "attachments");

    private String fieldName;
    private String columnName;

    EmployeeProperties(String fieldName, String columnName) {
        this.fieldName = fieldName;
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getColumnName() {
        return columnName;
    }
}
