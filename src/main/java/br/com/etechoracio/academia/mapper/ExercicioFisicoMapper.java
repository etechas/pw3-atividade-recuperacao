package br.com.etechoracio.academia.mapper;
import br.com.etechoracio.academia.DTO.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.DTO.ExercicioFisicoRequestDTO; 
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {
    ExercicioFisicoResponseDTO toResponseDTO(ExercicioFisico exercicioFisico);
    List<ExercicioFisicoResponseDTO> toResponseDTOList(List<ExercicioFisico> exerciciosFisicos);

    ExercicioFisico toEntity(ExercicioFisicoRequestDTO request);
}