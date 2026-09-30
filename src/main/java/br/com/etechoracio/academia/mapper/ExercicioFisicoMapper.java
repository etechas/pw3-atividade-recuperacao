package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {

    ExercicioFisicoResponseDTO toResponseDTO(ExercicioFisico entity);

    List<ExercicioFisicoResponseDTO> toResponseDTOList(List<ExercicioFisico> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovado", ignore = true)
    ExercicioFisico toEntity(ExercicioFisicoRequestDTO dto);
}