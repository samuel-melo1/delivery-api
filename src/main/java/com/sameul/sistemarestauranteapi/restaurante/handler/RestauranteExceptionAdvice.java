package com.sameul.sistemarestauranteapi.restaurante.handler;

import com.sameul.sistemarestauranteapi.common.model.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;

@ControllerAdvice
public class RestauranteExceptionAdvice {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
                                                                     HttpServletRequest request) {
        ErrorMessage error = new ErrorMessage(Instant.now(), HttpStatus.BAD_REQUEST.value(),
                "Valor inválido para parâmetro '" + exception.getName() + "': " + exception.getValue(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
