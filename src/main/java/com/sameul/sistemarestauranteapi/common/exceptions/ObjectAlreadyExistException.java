package com.sameul.sistemarestauranteapi.common.exceptions;

import com.sameul.sistemarestauranteapi.utils.IErrorCodeGlobal;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ObjectAlreadyExistException extends RuntimeException {

    private final HttpStatus status;
    public ObjectAlreadyExistException(IErrorCodeGlobal errorCode) {
        super(errorCode.getMessage());
        this.status = errorCode.getStatus();
    }
}
