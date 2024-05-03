package com.finan.orcamento.service;

import com.finan.orcamento.model.Casa;
import com.finan.orcamento.repositories.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {

    @Autowired
    private CasaRepository casaRepository;

    public List<Casa> buscarTodasCasas() {
        return casaRepository.findAll();
    }

    public Casa buscarCasaPorId(Long id) {
        Optional<Casa> obj = casaRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Casa não encontrada");
        }
    }

    public Casa cadastrarCasa(Casa casa) {
        return casaRepository.save(casa);
    }

    public void deletarCasaPorId(Long id) {
        casaRepository.deleteById(id);
    }

    public Casa atualizarCasa(Casa casa, Long id) {

        Optional<Casa> casaOptional = casaRepository.findById(id);
        if (casaOptional.isPresent()) {
            Casa casaToUpdate = casaOptional.get();
            casaToUpdate.setQuartos(casa.getQuartos());
            return casaRepository.save(casaToUpdate);
        } else {
            throw new RuntimeException("Casa não encontrada para atualização");
        }
    }
}
