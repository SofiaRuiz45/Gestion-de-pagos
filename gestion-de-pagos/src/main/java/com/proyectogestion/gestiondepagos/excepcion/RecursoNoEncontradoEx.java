package com.proyectogestion.gestiondepagos.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)

public class RecursoNoEncontradoEx extends RuntimeException{
    public  RecursoNoEncontradoEx(String mensaje){
        super(mensaje);
    }
}
