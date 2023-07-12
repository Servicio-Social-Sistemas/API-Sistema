package com.texhnolyze.formulariogeo.modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "encuestas")
@Data
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "encuesta_id")
    @Size(max = 8)
    private List<Pregunta> preguntas;

    @Embedded
    private PosicionGeografica posicionGeografica;

}
