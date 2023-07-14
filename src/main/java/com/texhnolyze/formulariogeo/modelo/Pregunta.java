package com.texhnolyze.formulariogeo.modelo;

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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_id")
    @Valid
    private Respuesta respuesta;
}
