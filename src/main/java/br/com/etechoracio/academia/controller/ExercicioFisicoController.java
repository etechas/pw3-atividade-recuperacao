package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.DTO.ExercicioFisicoResponseDTO; 
import br.com.etechoracio.academia.DTO.ExercicioFisicoRequestDTO; 
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    @Autowired
    private ExercicioFisicoService service;

    @GetMapping
    public List<ExercicioFisicoResponseDTO> listarAprovados() {
        return service.listarAprovados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        ExercicioFisicoResponseDTO dto = service.buscarPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDTO> cadastrar(@RequestBody ExercicioFisicoRequestDTO request) {
        ExercicioFisicoResponseDTO response = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponseDTO> aprovar(@PathVariable Long id) {
        ExercicioFisicoResponseDTO response = service.aprovar(id);
        
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}