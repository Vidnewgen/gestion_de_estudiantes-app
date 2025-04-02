package com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@jakarta.persistence.Table(name = "estudiante") // Asegúrate de que la tabla se llame "estudiante"
@Entity
public class Estudiante  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID
    private Long id;
    private String nombre;
    private String apellido;
    private String numeroInscripcion;
}
