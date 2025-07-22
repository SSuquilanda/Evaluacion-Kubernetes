package com.ups.vsdistribuidos.universidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ups.vsdistribuidos.universidades.model.Universidad;
import com.ups.vsdistribuidos.universidades.repository.UniversidadRepository;

@RestController
@RequestMapping("/api/universidades")
public class UniversidadController {

    @Autowired
    private UniversidadRepository universidadRepository;

    @GetMapping
    public List<Universidad> listar() {
        return universidadRepository.findAll();
    }

    @PostMapping
    public Universidad guardar(@RequestBody Universidad universidad) {
        return universidadRepository.save(universidad);
    }

    @PutMapping("/{id}")
    public Universidad actualizar(@PathVariable Long id, @RequestBody Universidad universidad) {
        return universidadRepository.findById(id).map(u -> {
            u.setNombre(universidad.getNombre());
            u.setCiudad(universidad.getCiudad());
            return universidadRepository.save(u);
        }).orElseGet(() -> {
            universidad.setId(id);
            return universidadRepository.save(universidad);
        });
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        universidadRepository.deleteById(id);
    }
}
