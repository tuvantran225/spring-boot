package model;

public class EmployeeSearchRequest {

    private String company;
    private String firstName;
    private String lastName;
    private Long privilegeId;

    public EmployeeSearchRequest() {
    }

    public EmployeeSearchRequest(String company, String firstName, String lastName, Long privilegeId) {
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.privilegeId = privilegeId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}
