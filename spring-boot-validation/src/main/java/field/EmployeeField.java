package field;

public enum EmployeeField implements Field {
    ID("Id"),
    COMPANY("Company"),
    FIRST_NAME("First name"),
    LAST_NAME("Last name");

    private final String name;

    EmployeeField(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
