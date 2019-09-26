package model;

import java.util.List;

public class ErrorResponseEntity extends ResponseEntity {

    private List<String> errors;

    public ErrorResponseEntity(int status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    public List<String> getErrors() {
        return errors;
    }
}
