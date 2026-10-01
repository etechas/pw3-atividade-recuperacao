package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {
    @Autowired
    private ExercicioFisicoService exercicioFisicoService;

    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponseDTO>> findAprovados()
    {
        return ResponseEntity.ok(exercicioFisicoService.findAprovados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> findPorId(@PathVariable Long id)
    {
        ExercicioFisicoResponseDTO exercicio = exercicioFisicoService.findPorId(id);

        if(exercicio == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(exercicio);
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDTO> save(@RequestBody ExercicioFisicoRequestDTO exercicioFisicoDTO)
    {
        ExercicioFisicoResponseDTO exercicioSalvo = exercicioFisicoService.save(exercicioFisicoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioSalvo);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponseDTO> aprovar(@PathVariable Long id) {
        ExercicioFisicoResponseDTO exercicioDto = exercicioFisicoService.aprovar(id);
        if (exercicioDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(exercicioDto);
    }

}
