package com.texhnolyze.formulariogeo.servicio;

import com.texhnolyze.formulariogeo.modelo.Encuesta;
import com.texhnolyze.formulariogeo.modelo.PosicionGeografica;
import com.texhnolyze.formulariogeo.modelo.Pregunta;
import com.texhnolyze.formulariogeo.repositorio.EncuestaRespositorio;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncuestaServicio {

    private final EncuestaRespositorio encuestaRespositorio;

    public EncuestaServicio(EncuestaRespositorio encuestaRespositorio) {
        this.encuestaRespositorio = encuestaRespositorio;
    }

    public void save(Encuesta encuesta){
        // Verificar si se alcanzó el límite de 8 preguntas
        if (encuesta.getPreguntas().size() >= 8) {
            throw new IllegalArgumentException("Se ha alcanzado el límite máximo de preguntas (8) en la encuesta.");
        }

        // Asignar el número de pregunta a cada pregunta en la lista
        List<Pregunta> preguntas = encuesta.getPreguntas();
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            pregunta.setNumeroPregunta(i + 1);
            pregunta.setEncuesta(encuesta);
        }

        encuestaRespositorio.save(encuesta);
    }

    public Encuesta findById(Long id){
        return encuestaRespositorio.findById(id).orElseThrow(()->
                new RuntimeException("No se encontro la encuesta con id: "+id));
    }

    public List<PosicionGeografica> findAllPosicionGeografica(){
        return encuestaRespositorio.findAll().stream()
                .map(Encuesta::getPosicionGeografica)
                .toList();
    }

    public List<Encuesta> findAll() {
        return encuestaRespositorio.findAll();
    }
    public Encuesta getEncuestadoById(Long id) {
        return encuestaRespositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro la encuesta con id: "+id));
    }

    public void updateEncuestadoById(Long id, Encuesta encuestado) {
         Encuesta encuesta = encuestaRespositorio.findById(id).orElseThrow(()->
                new RuntimeException("No se encontro la encuesta con id: "+id));
         Encuesta encuestaActualizada =  Encuesta.builder()
                    .id(encuesta.getId())
                    .preguntas(encuestado.getPreguntas())
                    .build();

         encuestaRespositorio.save(encuestaActualizada);

    }

    public void deleteEncuestado(Long id) {
        if (encuestaRespositorio.findById(id).isPresent()) {
            encuestaRespositorio.deleteById(id);
        }
    }

    public List<Pregunta> buscarPreguntasPorEncuestaId(Long id){
        Encuesta encuesta = getEncuestadoById(id);
        return encuesta.getPreguntas();
    }

}
