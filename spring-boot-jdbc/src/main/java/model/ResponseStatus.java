package model;

public enum ResponseStatus {

    SUCCESS(200), ERROR(201);

    private int code;

    ResponseStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
