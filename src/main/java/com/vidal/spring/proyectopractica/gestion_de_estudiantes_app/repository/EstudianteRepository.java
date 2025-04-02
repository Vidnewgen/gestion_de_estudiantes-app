package com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.models.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}