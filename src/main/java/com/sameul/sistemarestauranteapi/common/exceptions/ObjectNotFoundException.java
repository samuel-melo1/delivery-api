package com.sameul.sistemarestauranteapi.common.exceptions;

import com.sameul.sistemarestauranteapi.utils.IErrorCodeGlobal;
import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends RuntimeException {
    private  final HttpStatus status;
    public ObjectNotFoundException(IErrorCodeGlobal errorCode){
        super(errorCode.getMessage());
        this.status = errorCode.getStatus();
    }
}
