package rest_with_spring_boot_and_java_erudio.services;

import org.springframework.stereotype.Service;
import rest_with_spring_boot_and_java_erudio.exception.UnsupportedMathOperationException;

@Service
public class MathService {

    public Double sum(String numberOne,
                      String numberTwo) throws IllegalAccessException {
        return Double.sum(this.convertoDouble(numberOne),
                this.convertoDouble(numberTwo));
    }

    public Double subtraction(String numberOne,
                              String numberTwo) throws IllegalAccessException {
        return this.convertoDouble(numberOne) - this.convertoDouble(numberTwo);
    }

    public Double division(String numberOne,
                           String numberTwo) throws IllegalAccessException {
        return this.convertoDouble(numberOne) / this.convertoDouble(numberTwo);
    }

    private Boolean validaNumber(String num){
        if (num == null || num.isEmpty()) return false;
        return num.replace(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertoDouble(String num) throws IllegalAccessException {
        if (!validaNumber(num)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Double.parseDouble(num.replace(",", "."));
    }
}
