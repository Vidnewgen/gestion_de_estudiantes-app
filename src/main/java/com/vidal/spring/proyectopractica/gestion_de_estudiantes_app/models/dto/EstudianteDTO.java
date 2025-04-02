package com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class EstudianteDTO {

    private Long id; 
    private String nombre;
    private String apellido;
    private String numeroInscripcion;

}
