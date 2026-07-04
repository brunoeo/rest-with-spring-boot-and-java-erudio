package rest_with_spring_boot_and_java_erudio.exception.hadler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import rest_with_spring_boot_and_java_erudio.exception.ExceptionResponse;
import rest_with_spring_boot_and_java_erudio.exception.UnsupportedMathOperationException;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomEntityResponseHadler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> hndleAllException(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> hndleBadRequestException(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
