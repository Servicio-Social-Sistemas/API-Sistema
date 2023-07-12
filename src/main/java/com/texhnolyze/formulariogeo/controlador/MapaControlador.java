package com.texhnolyze.formulariogeo.controlador;


import com.texhnolyze.formulariogeo.modelo.Encuesta;
import com.texhnolyze.formulariogeo.modelo.PosicionGeografica;
import com.texhnolyze.formulariogeo.servicio.EncuestaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mapa")
public class MapaControlador {

    private final EncuestaServicio encuestaServicio;

    public MapaControlador(EncuestaServicio encuestaServicio) {
        this.encuestaServicio = encuestaServicio;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PosicionGeografica> getMapa(@PathVariable Long id){
        Encuesta escuestaPosicion = encuestaServicio.findById(id);
        if(escuestaPosicion.getPosicionGeografica()!=null){
            return ResponseEntity.ok(escuestaPosicion.getPosicionGeografica());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<PosicionGeografica>> getAllMapas(){
        return ResponseEntity.ok(encuestaServicio.findAllPosicionGeografica());
    }
}
