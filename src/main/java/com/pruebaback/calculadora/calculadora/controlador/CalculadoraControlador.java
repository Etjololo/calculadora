package com.pruebaback.calculadora.calculadora.controlador;

import com.pruebaback.calculadora.calculadora.servicios.CalculadoraServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api/calculadora")
@RequiredArgsConstructor
public class CalculadoraControlador {

    private final CalculadoraServicio calculadoraServicio;

    @GetMapping("/suma/{parametro1}+{parametro2}")
    public ResponseEntity<Long> suma(@PathVariable long parametro1, @PathVariable long parametro2) {
        Long resultado = calculadoraServicio.suma(parametro1, parametro2);

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/resta/{parametro1}-{parametro2}")
    public ResponseEntity<Long> resta(@PathVariable long parametro1, @PathVariable long parametro2) {
        Long resultado = calculadoraServicio.resta(parametro1, parametro2);

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleException(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("mensaje", "Por favor, introduce argumentos validos para la operacion.");
        map.put("fecha y hora", new Date());
        map.put("error", HttpStatus.BAD_REQUEST);
        map.put("codigo", HttpStatus.BAD_REQUEST.value());
        return map;
    }
}
