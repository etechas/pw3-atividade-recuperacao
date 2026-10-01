package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioFisicoService {
    @Autowired
    private ExercicioFisicoRepository exercicioFisicoRepository;

    @Autowired
    private ExercicioFisicoMapper exercicioFisicoMapper;

    public List<ExercicioFisicoResponseDTO> findAprovados(){
        List<ExercicioFisico> exercicios = exercicioFisicoRepository.findAprovados();
        return exercicioFisicoMapper.toResponseDTOList(exercicios);
    }

    public ExercicioFisicoResponseDTO findPorId(Long id)
    {
        ExercicioFisico exercicio = exercicioFisicoRepository.findporId(id);
        if(exercicio == null)
            return null;
        else
            return exercicioFisicoMapper.toResponseDTO(exercicio);
    }

    public ExercicioFisicoResponseDTO save(ExercicioFisicoRequestDTO exercicioFisicoDto){
        ExercicioFisico exercicio = exercicioFisicoMapper.toEntity(exercicioFisicoDto);
        exercicio.setAprovado(false);
        ExercicioFisico exercicioSalvo = exercicioFisicoRepository.save(exercicio);
        return exercicioFisicoMapper.toResponseDTO(exercicioSalvo);
    }

    public ExercicioFisicoResponseDTO aprovar(Long id){
        Optional<ExercicioFisico> optionalExercicio = exercicioFisicoRepository.findById(id);
        if(optionalExercicio.isPresent()) {
            ExercicioFisico exercicio = optionalExercicio.get();
            exercicio.setAprovado(true);
            exercicioFisicoRepository.save(exercicio);
            return exercicioFisicoMapper.toResponseDTO(exercicio);
        }
        else
            return null;
    }

}
