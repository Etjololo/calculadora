package com.pruebaback.calculadora.calculadora.controlador;

import com.pruebaback.calculadora.calculadora.servicios.CalculadoraServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/calculadora")
@RequiredArgsConstructor
public class CalculadoraControlador {

    private final CalculadoraServicio calculadoraServicio;

    @GetMapping("/suma/{parametro1}/{parametro2}")
    @ResponseStatus(HttpStatus.OK)
    public void suma(@PathVariable long parametro1, @PathVariable long parametro2) {
        calculadoraServicio.suma(parametro1, parametro2);
    }

    @GetMapping("/resta/{parametro1}/{parametro2}")
    @ResponseStatus(HttpStatus.OK)
    public void resta(@PathVariable long parametro1, @PathVariable long parametro2) {
        calculadoraServicio.resta(parametro1, parametro2);
    }
}
