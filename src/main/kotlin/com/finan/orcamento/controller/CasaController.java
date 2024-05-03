package com.finan.orcamento.controller;

import com.finan.orcamento.model.Casa;
import com.finan.orcamento.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/casas")
public class CasaController {

    @Autowired
    private CasaService casaService;

    @GetMapping
    public ResponseEntity<List<Casa>> buscarTodasCasas() {
        return ResponseEntity.ok(casaService.buscarTodasCasas());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Casa> buscarCasaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(casaService.buscarCasaPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Casa> cadastrarCasa(@RequestBody Casa casa) {
        return ResponseEntity.ok(casaService.cadastrarCasa(casa));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Casa> atualizarCasa(@RequestBody Casa casa, @PathVariable Long id) {
        Casa casaAtualizada = casaService.atualizarCasa(casa, id);
        return ResponseEntity.ok(casaAtualizada);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarCasa(@PathVariable Long id) {
        casaService.deletarCasaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
