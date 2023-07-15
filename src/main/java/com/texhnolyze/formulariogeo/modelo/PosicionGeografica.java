package com.texhnolyze.formulariogeo.modelo;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.Data;

@Embeddable
@Data
public class PosicionGeografica {
    @NotNull(message = "La latitud no puede ser vacía")
    @Min(value = -90, message = "La latitud debe ser mayor a -90")
    @Max(value = 90, message = "La latitud debe ser menor a 90")
    private Double latitud;
    @NotNull(message = "La longitud no puede ser vacía")
    @Min(value = -180, message = "La longitud debe ser mayor a -180")
    @Max(value = 180, message = "La longitud debe ser menor a 180")
    private Double longitud;
}
