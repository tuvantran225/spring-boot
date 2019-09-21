package model;

public class ResponseEntity<T> {

    private int status;
    private String error;
    private String message;
    private T data;

    public ResponseEntity(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseEntity(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public ResponseEntity(int status, String error, String message, T data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
