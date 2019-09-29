package model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class Employee {

    private Long id;
    @NotEmpty(message = "Company is required")
    private String company;
    @Length(max = 50, message = "Last name cannot greater than 50 characters")
    private String lastName;
    private String firstName;
    private String email;
    private String job;
    private String businessPhone;
    private String homePhone;
    private String mobilePhone;
    private String faxNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String webPage;
    private String notes;
    private byte[] attachments;

    public Employee(Long id, String company, String lastName, String firstName, String email, String job,
                    String businessPhone, String homePhone, String mobilePhone, String faxNumber, String address,
                    String city, String state, String zipCode, String country, String webPage, String notes,
                    byte[] attachments) {
        this.id = id;
        this.company = company;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.job = job;
        this.businessPhone = businessPhone;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.faxNumber = faxNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.webPage = webPage;
        this.notes = notes;
        this.attachments = attachments;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getJob() {
        return job;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getWebPage() {
        return webPage;
    }

    public String getNotes() {
        return notes;
    }

    public byte[] getAttachments() {
        return attachments;
    }
}
