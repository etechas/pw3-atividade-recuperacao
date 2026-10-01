package br.com.etechoracio.academia.repository;

import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExercicioFisicoRepository extends JpaRepository<ExercicioFisico, Long> {
    @Query("SELECT e from ExercicioFisico e where e.aprovado = true")
    List<ExercicioFisico> findAprovados();

    @Query("SELECT e from ExercicioFisico e where e.aprovado = true AND e.id = ?1")
    ExercicioFisico findporId(Long id);
}
