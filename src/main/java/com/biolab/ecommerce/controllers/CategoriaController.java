package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.services.CategoriaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarCat(@RequestBody CategoriaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCategoria(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCat(@PathVariable long id) {
        return ResponseEntity.ok().body(service.buscarCatId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCat(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCategoria(@Valid @PathVariable("id") long id, @RequestBody CategoriaDTO dto){
        return ResponseEntity.ok(service.alterarCategoria(id, dto));
    }

}
