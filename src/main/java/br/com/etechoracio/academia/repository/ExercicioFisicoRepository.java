package br.com.etechoracio.academia.repository;

import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExercicioFisicoRepository extends JpaRepository<ExercicioFisico, Long> {

    // Etapa 1: Busca exercícios onde aprovado = true
    List<ExercicioFisico> findByAprovadoTrue();

    // Etapa 2: Busca por ID onde aprovado = true
    Optional<ExercicioFisico> findByIdAndAprovadoTrue(Long id);
}