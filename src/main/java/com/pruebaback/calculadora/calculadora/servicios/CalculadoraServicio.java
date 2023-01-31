package com.pruebaback.calculadora.calculadora.servicios;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import io.corp.calculator.*;

@Service
@RequiredArgsConstructor
public class CalculadoraServicio {

    private TracerImpl traza = new TracerImpl();

    public void suma(Long parametro1, Long parametro2) {
        Long resultado = parametro1 + parametro2;

        traza.trace(resultado);
    }

    public void resta(Long parametro1, Long parametro2) {
        Long resultado = parametro1 - parametro2;

        traza.trace(resultado);
    }
}
