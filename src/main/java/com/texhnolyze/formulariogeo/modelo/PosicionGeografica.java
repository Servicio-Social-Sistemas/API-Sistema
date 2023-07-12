package com.texhnolyze.formulariogeo.modelo;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PosicionGeografica {
    private double latitud;
    private double longitud;
}
