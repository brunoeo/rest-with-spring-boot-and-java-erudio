package rest_with_spring_boot_and_java_erudio.exception.hadler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rest_with_spring_boot_and_java_erudio.exception.ExceptionResponse;
import rest_with_spring_boot_and_java_erudio.util.AppResponse;
import rest_with_spring_boot_and_java_erudio.util.DataResponse;

import java.util.Date;

@ControllerAdvice
public class CustomEntityResponseHadler {

    @ExceptionHandler({ExceptionResponse.class})
    public AppResponse<DataResponse> handleException(ExceptionResponse ex) {
        return AppResponse.error(ex.getMessage(), ex.getStatus());
    }
}
