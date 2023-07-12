package com.texhnolyze.formulariogeo.servicio;

import com.texhnolyze.formulariogeo.modelo.Encuesta;
import com.texhnolyze.formulariogeo.repositorio.EncuestaRespositorio;
import org.springframework.stereotype.Service;

@Service
public class EncuestaServicio {

    private final EncuestaRespositorio encuestaRespositorio;

    public EncuestaServicio(EncuestaRespositorio encuestaRespositorio) {
        this.encuestaRespositorio = encuestaRespositorio;
    }

    public void save(Encuesta encuesta){
        encuestaRespositorio.save(encuesta);
    }

    public Encuesta findById(Long id){
        return encuestaRespositorio.findById(id).orElseThrow(()->
                new RuntimeException("No se encontro la encuesta con id: "+id));
    }

}
