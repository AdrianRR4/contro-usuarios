package _dr21.contro_usuarios.controllers.exception;

import _dr21.contro_usuarios.exception.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handlerValidationErrors(MethodArgumentNotValidException ex){

        ApiError apiError= new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setError("Validation Error");

        List<ApiError.ValidationError> validationErrors= ex.getBindingResult().getFieldErrors().stream().
                map(fieldError -> {
                    ApiError.ValidationError error= new ApiError.ValidationError();
                    error.setField(fieldError.getField());
                    error.setMessage(fieldError.getDefaultMessage());
                    error.setRejectValue(String.valueOf(fieldError.getRejectedValue()));
                    return error;
                }).collect(Collectors.toList());
        apiError.setErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }
}


