package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    @Autowired
    private ExercicioFisicoService service;

    // Etapa 1
    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponseDTO>> listar() {
        List<ExercicioFisicoResponseDTO> lista = service.listarAprovados();
        return ResponseEntity.ok(lista);
    }
    // Etapa 2
    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarAprovadoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Etapa 3
    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDTO> cadastrar(@RequestBody ExercicioFisicoRequestDTO dto) {
        ExercicioFisicoResponseDTO criado = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }
}