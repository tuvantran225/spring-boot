package http;

public class ErrorResponse<T> extends Response {

    private T message;

    public ErrorResponse(int status, T message) {
        super(status);
        this.message = message;
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}
