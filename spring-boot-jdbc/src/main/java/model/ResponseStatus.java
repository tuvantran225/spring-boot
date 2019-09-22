package model;

public enum ResponseStatus {

    SUCCESS(200, "Success"), ERROR(201, "Error");

    private int code;
    private String error;

    ResponseStatus(int code, String error) {
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

}
