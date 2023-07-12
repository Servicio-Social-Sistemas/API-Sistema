package com.texhnolyze.formulariogeo.controlador;

import com.texhnolyze.formulariogeo.modelo.Encuesta;
import com.texhnolyze.formulariogeo.servicio.EncuestaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/encuesta")
public class EncuestaControlador {

    private final EncuestaServicio encuestaServicio;

    public EncuestaControlador(EncuestaServicio encuestaServicio) {
        this.encuestaServicio = encuestaServicio;
    }

    @PostMapping
    public ResponseEntity<String> addEncuesta(@RequestBody Encuesta encuesta){
        encuestaServicio.save(encuesta);
        return ResponseEntity.ok("Encuesta agregada");
    }

}
