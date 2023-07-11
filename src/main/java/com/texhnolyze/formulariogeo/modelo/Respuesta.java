package com.texhnolyze.formulariogeo.modelo;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "respuestas")
@Data
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;


}