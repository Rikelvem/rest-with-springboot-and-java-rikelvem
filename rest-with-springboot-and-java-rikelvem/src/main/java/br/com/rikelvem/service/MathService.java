package br.com.rikelvem.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    private final String ERROR_MESSAGE = "Por favor, informe um número válido";

    public Double convertToDouble(String strNumber) throws UnsupportedOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException(ERROR_MESSAGE);
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public boolean isNumeric(String strNumber) throws UnsupportedOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException(ERROR_MESSAGE);
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
