package http;

public class SuccessResponse<T> extends Response {

    private T data;

    public SuccessResponse(int status, T data) {
        super(status);
        this.data = data;
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
