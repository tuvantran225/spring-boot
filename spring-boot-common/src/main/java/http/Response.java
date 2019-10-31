package http;

public abstract class Response {

    protected int status;

    protected Response(int status) {
        this.status = status;
    }

    protected int getStatus() {
        return status;
    }

    protected void setStatus(int status) {
        this.status = status;
    }

}
