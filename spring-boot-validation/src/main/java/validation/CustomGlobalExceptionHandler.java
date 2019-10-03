package validation;

import model.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", ResponseStatus.SUCCESS.getCode());

        //Get all errors
        Map<String, List<String>> errorMap = new HashMap<>();
        ArrayList<String> errorMessages = null;
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .sorted((o1, o2) -> o1.getField().compareTo(o2.getField()))
                .collect(Collectors.toList());
        for (FieldError fieldError : fieldErrors) {
            if (errorMap.get(fieldError.getField()) == null) {
                errorMessages = new ArrayList<>();
                errorMessages.add(fieldError.getDefaultMessage());
                errorMap.put(fieldError.getField(), errorMessages);
            } else {
                errorMessages.add(fieldError.getDefaultMessage());
                errorMap.put(fieldError.getField(), errorMessages);
            }
        }

        body.put("errors", errorMap);
        return new ResponseEntity<>(body, status);
    }

}