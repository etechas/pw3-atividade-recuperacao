package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioFisicoService {

    @Autowired
    private ExercicioFisicoRepository repository;

    @Autowired
    private ExercicioFisicoMapper mapper;

    // Etapa 1
    public List<ExercicioFisicoResponseDTO> listarAprovados() {
        List<ExercicioFisico> entidades = repository.findByAprovadoTrue();
        return mapper.toResponseDTOList(entidades);
    }
    // Etapa 2
    public Optional<ExercicioFisicoResponseDTO> buscarAprovadoPorId(Long id) {
        return repository.findByIdAndAprovadoTrue(id)
                .map(mapper::toResponseDTO);
    }
    // Etapa 3
    public ExercicioFisicoResponseDTO cadastrar(ExercicioFisicoRequestDTO dto) {
        ExercicioFisico entidade = mapper.toEntity(dto);
        entidade.setAprovado(false); // Regra: nasce como desaprovado

        ExercicioFisico salvo = repository.save(entidade);
        return mapper.toResponseDTO(salvo);
    }
    // Etapa 4
    public Optional<ExercicioFisicoResponseDTO> aprovar(Long id) {
        Optional<ExercicioFisico> opt = repository.findById(id);
        
        if (opt.isEmpty()) {
            return Optional.empty();
        }

        ExercicioFisico entidade = opt.get();
        entidade.setAprovado(true);

        ExercicioFisico atualizado = repository.save(entidade);
        return Optional.of(mapper.toResponseDTO(atualizado));
    }
}