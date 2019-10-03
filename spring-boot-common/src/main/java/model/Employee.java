package model;

public class Employee {

    private Long id;
    private String company;
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
    private Byte[] attachments;

    public Employee() {
    }

    public Employee(Long id, String company, String lastName, String firstName, String email, String job,
                    String businessPhone, String homePhone, String mobilePhone, String faxNumber, String address,
                    String city, String state, String zipCode, String country, String webPage, String notes) {
        this(id, company, lastName, firstName, email, job, businessPhone, homePhone, mobilePhone, faxNumber, address,
                city, state, zipCode, country, webPage, notes, null);
    }

    public Employee(Long id, String company, String lastName, String firstName, String email, String job,
                    String businessPhone, String homePhone, String mobilePhone, String faxNumber, String address,
                    String city, String state, String zipCode, String country, String webPage, String notes,
                    Byte[] attachments) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Byte[] attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", webPage='" + webPage + '\'' +
                ", notes='" + notes + '\'' +
                ", attachments=" + java.util.Arrays.toString(attachments) +
                '}';
    }
}
