package com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.mappers.EstudianteMapper;
import com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.models.Estudiante;
import com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.models.dto.EstudianteDTO;
import com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.repository.EstudianteRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/est")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EstudianteMapper estudianteMapper;

    @GetMapping("/getEst")
    public List<EstudianteDTO> obtenerEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudianteMapper.convertToDTOList(estudiantes);
    }

    @GetMapping("/getOneEst/{id}")
    public EstudianteDTO obtenerEstudiantePorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el estudiante con el ID " + id));
        return estudianteMapper.toDTO(estudiante);
    }

    @PostMapping("/postEst")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        Estudiante estudiante = EstudianteMapper.INSTANCE.toEntity(estudianteDTO);
        Estudiante nuevoEstudiante = estudianteRepository.save(estudiante);

        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteMapper.toDTO(nuevoEstudiante));
    }

    @PutMapping("updateEst/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id,
            @RequestBody EstudianteDTO detallesEstudiante) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el estudiante con el ID " + id));

        estudiante.setNombre(detallesEstudiante.getNombre());
        estudiante.setApellido(detallesEstudiante.getApellido());
        estudiante.setNumeroInscripcion(detallesEstudiante.getNumeroInscripcion());

        estudianteRepository.save(estudiante);

        return ResponseEntity.ok(EstudianteMapper.INSTANCE.toDTO(estudiante)); // mandamos el codigo 200 OK
    }

    @DeleteMapping("deleteOneEst/{id}")
    public ResponseEntity<Void> borrarEstudiante(@PathVariable Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el estudiante con el ID " + id));

        estudianteRepository.delete(estudiante);

        return ResponseEntity.noContent().build(); // Devolvemos el codigo 204 como No Content
    }    
    
}
