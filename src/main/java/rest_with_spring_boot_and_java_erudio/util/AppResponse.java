package rest_with_spring_boot_and_java_erudio.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rest_with_spring_boot_and_java_erudio.dto.PersonDTO;

import java.util.List;

public class AppResponse <T extends DataResponse> extends ResponseEntity<T> {

    public AppResponse(T body, HttpStatus status) {
        super(body, status);
    }

    public static AppResponse<DataResponse> success(PersonDTO body, String message) {
        return new AppResponse<>(new DataResponse(message, body), HttpStatus.OK);
    }

    public static AppResponse<DataResponse> success(String message) {
        return new AppResponse<>(new DataResponse(message), HttpStatus.OK);
    }

    public static AppResponse<DataResponse> error(String message, HttpStatus status) {
        return new AppResponse<>(new DataResponse(message), status);
    }


    public static AppResponse<DataResponse> success(List<PersonDTO> body, String message) {
        return new AppResponse<>(new DataResponse(message, body), HttpStatus.OK);
    }
}
