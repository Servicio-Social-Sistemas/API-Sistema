package com.texhnolyze.formulariogeo.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
@Entity
@Table(name = "preguntas")
@Data
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroPregunta;

    @ManyToOne
    @JoinColumn(name = "encuesta_id")
    @JsonBackReference
    private Encuesta encuesta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_id")
    @Valid
    private Respuesta respuesta;
}
