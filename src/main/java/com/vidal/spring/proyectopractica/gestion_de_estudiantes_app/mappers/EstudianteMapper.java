package com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.models.Estudiante;
import com.vidal.spring.proyectopractica.gestion_de_estudiantes_app.models.dto.EstudianteDTO;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(source = "id", target = "id")
    EstudianteDTO toDTO(Estudiante estudiante);

    @Mapping(source = "id", target = "id")
    Estudiante toEntity(EstudianteDTO estudianteDTO);

    List<EstudianteDTO> convertToDTOList(List<Estudiante> estudiantes);

    List<Estudiante> convertToEntityList(List<EstudianteDTO> estudiantesDTO);
}