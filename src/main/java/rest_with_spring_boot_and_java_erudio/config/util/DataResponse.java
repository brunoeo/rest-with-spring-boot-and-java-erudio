package rest_with_spring_boot_and_java_erudio.config.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataResponse {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private Object data;

    public DataResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public DataResponse(String message) {
        this.message = message;
    }

    public String getMensage() {
        return message;
    }

    public void setMensage(String mensage) {
        this.message = mensage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
