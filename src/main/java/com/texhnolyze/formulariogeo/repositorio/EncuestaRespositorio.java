package com.texhnolyze.formulariogeo.repositorio;

import com.texhnolyze.formulariogeo.modelo.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRespositorio extends JpaRepository<Encuesta, Long>{

}
