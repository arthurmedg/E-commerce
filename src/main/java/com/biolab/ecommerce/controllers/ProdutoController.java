package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable long id) {
        ProdutoDTO produtoDTO = service.buscarProdId(id);

        return ResponseEntity.ok(produtoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id) {
        String mensagem = service.deletarProduto(id);
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterar(@PathVariable long id, @RequestBody ProdutoDTO request) {
        String mensagem = service.alterarProduto(id, request);
        return ResponseEntity.ok(mensagem);
    }

}
