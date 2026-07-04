package rest_with_spring_boot_and_java_erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_with_spring_boot_and_java_erudio.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo) throws IllegalAccessException {
        return Double.sum(this.convertoDouble(numberOne),
                this.convertoDouble(numberTwo));
    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne,
                              @PathVariable String numberTwo) throws IllegalAccessException {
        return this.convertoDouble(numberOne) - this.convertoDouble(numberTwo);
    }

    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne,
                           @PathVariable String numberTwo) throws IllegalAccessException {
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
