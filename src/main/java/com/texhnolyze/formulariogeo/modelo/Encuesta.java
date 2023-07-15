package com.texhnolyze.formulariogeo.modelo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "encuestas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL)
    @Size(max = 8, message = "La lista de preguntas debe tener como máximo 8 elementos")
    @JsonManagedReference
    private List<@Valid Pregunta> preguntas;

    @Embedded
    @Valid
    private PosicionGeografica posicionGeografica;

}
