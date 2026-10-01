package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {
    List<ExercicioFisicoResponseDTO> toResponseDTOList(List<ExercicioFisico> entities);
    List<ExercicioFisico> toResponseEntities(List<ExercicioFisicoResponseDTO> dtos);

    ExercicioFisicoResponseDTO toResponseDTO(ExercicioFisico entity);

    ExercicioFisico toEntity(ExercicioFisicoRequestDTO dto);
}
