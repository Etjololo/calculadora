package com.pruebaback.calculadora.calculadora.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import io.corp.calculator.*;

@Service
@RequiredArgsConstructor
@Log4j2
public class CalculadoraServicio {

    private TracerImpl traza = new TracerImpl();

    public Long suma(Long parametro1, Long parametro2) {
        Long resultado = parametro1 + parametro2;

        traza.trace(resultado);
        log.info("El resultado de la operacion es {}", resultado);
        return resultado;
    }

    public Long resta(Long parametro1, Long parametro2) {
        Long resultado = parametro1 - parametro2;

        traza.trace(resultado);
        log.info("El resultado de la operacion es {}", resultado);
        return resultado;
    }
}
