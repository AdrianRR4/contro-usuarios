package _dr21.contro_usuarios.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {

    private LocalDateTime timestamp;

    private int status;

    private String error;

    private List<ValidationError> errors;

    @Data
    public static class ValidationError{
        private String field;
        private String message;
        private String rejectValue;
    }
}
