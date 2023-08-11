package td.example.prog4.employeedb.model.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ServerException {
    public InternalServerErrorException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
