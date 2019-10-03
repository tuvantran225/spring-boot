package model;

public class SuccessResponseEntity<T> extends ResponseEntity {

    private T data;

    public SuccessResponseEntity(int status, T data) {
        this.status = status;
        this.data = data;
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    public T getData() {
        return data;
    }
}
