package com.texhnolyze.formulariogeo.controlador;

import com.texhnolyze.formulariogeo.modelo.Encuesta;
import com.texhnolyze.formulariogeo.servicio.EncuestaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<Encuesta>> todasEncuestas() {
        return ResponseEntity.ok(encuestaServicio.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity <Encuesta> getEncuestadoById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(encuestaServicio.getEncuestadoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEncuestadoById(@PathVariable("id") Long id, @RequestBody Encuesta encuestado) {
        encuestaServicio.updateEncuestadoById(id, encuestado);
        return ResponseEntity.ok("Encuesta actualizada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEncuestado(@PathVariable("id") Long id) {
        encuestaServicio.deleteEncuestado(id);
        return ResponseEntity.ok("Encuesta eliminada");

    }

}
