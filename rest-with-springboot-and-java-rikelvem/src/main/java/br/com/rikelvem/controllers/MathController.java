package br.com.rikelvem.controllers;

import br.com.rikelvem.service.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static jakarta.servlet.RequestDispatcher.ERROR_MESSAGE;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService service;

    public MathController(MathService service) {
        this.service = service;
    }
    
    private final String ERROR_MESSAGE = "Por favor, informe um número válido";

    @RequestMapping("/sum/{firstNumber}/{secondNumber}")
    public Double sum(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) throws Exception {
        if (!service.isNumeric(firstNumber) || !service.isNumeric(secondNumber)) throw new UnsupportedOperationException(ERROR_MESSAGE);
        return service.convertToDouble(firstNumber) + service.convertToDouble(secondNumber);
    }

    @RequestMapping("/subtraction/{firstNumber}/{secondNumber}")
    public Double subtraction(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) throws Exception {
        if (!service.isNumeric(firstNumber) || !service.isNumeric(secondNumber)) throw new UnsupportedOperationException(ERROR_MESSAGE);
        return service.convertToDouble(firstNumber) - service.convertToDouble(secondNumber);
    }

    @RequestMapping("/multiplication/{firstNumber}/{secondNumber}")
    public Double multiplication(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) throws Exception {
        if (!service.isNumeric(firstNumber) || !service.isNumeric(secondNumber)) throw new UnsupportedOperationException(ERROR_MESSAGE);
        return service.convertToDouble(firstNumber) * service.convertToDouble(secondNumber);
    }

    @RequestMapping("/division/{firstNumber}/{secondNumber}")
    public Double division(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) throws Exception {
        if (!service.isNumeric(firstNumber) || !service.isNumeric(secondNumber)) throw new UnsupportedOperationException(ERROR_MESSAGE);
        if (service.convertToDouble(secondNumber) == 0) throw new UnsupportedOperationException("Não é possível dividir por zero");
        return service.convertToDouble(firstNumber) / service.convertToDouble(secondNumber);
    }

    @RequestMapping("/mean/{firstNumber}/{secondNumber}")
    public Double mean(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) throws Exception {
        if (!service.isNumeric(firstNumber) || !service.isNumeric(secondNumber)) throw new UnsupportedOperationException(ERROR_MESSAGE);
        return (service.convertToDouble(firstNumber) + service.convertToDouble(secondNumber)) / 2;
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!service.isNumeric(number)) throw new UnsupportedOperationException(ERROR_MESSAGE);
        Double num = service.convertToDouble(number);
        if (num < 0) throw new UnsupportedOperationException("Não é possível calcular a raiz quadrada de um número negativo");
        return Math.sqrt(num);
    }

}
