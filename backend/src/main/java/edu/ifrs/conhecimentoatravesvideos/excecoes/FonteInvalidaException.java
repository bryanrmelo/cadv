package edu.ifrs.conhecimentoatravesvideos.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Fonte inválida")
public class FonteInvalidaException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Login invalido";
    }
}
