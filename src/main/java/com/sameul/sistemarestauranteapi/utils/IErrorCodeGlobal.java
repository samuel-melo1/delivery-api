package com.sameul.sistemarestauranteapi.utils;

import org.springframework.http.HttpStatus;

public interface IErrorCodeGlobal {
    String getMessage();
    HttpStatus getStatus();
}
