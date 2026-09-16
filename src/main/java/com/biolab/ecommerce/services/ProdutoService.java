package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.entities.Categoria;
import com.biolab.ecommerce.entities.Produto;
import com.biolab.ecommerce.repositories.CategoriaRepository;
import com.biolab.ecommerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }


    public String criar(ProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setPreco(dto.getPreco());
        p.setImgUrl(dto.getImgUrl());

        Categoria cat = categoriaRepository.getReferenceById(dto.getIdCategoria());
        p.getCategorias().add(cat);

        produtoRepository.save(p);
        return "Produto salvo com sucesso";
    }


    public ProdutoDTO buscarProdId(long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return new ProdutoDTO(
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getImgUrl(),
                produto.getCategorias().stream()
                        .map(cat -> new Categoria(cat.getId(), cat.getNome(), new HashSet<>()))
                        .collect(java.util.stream.Collectors.toSet())
        );
    }


    public String deletarProduto(long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            return "A tarefa não existe";
        }else {
            produtoRepository.deleteById(id);
            return "Tarefa removida com sucesso!";
        }
    }


    public String alterarProduto(long id, ProdutoDTO request) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Erro: Produto não foi encontrado no sistema!"));

        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());
        produto.setImgUrl(request.getImgUrl());

        if (request.getCategoriaList() != null) {
            produto.setCategorias(request.getCategoriaList());
        }

        produtoRepository.save(produto);
        return "Produto editado com sucesso!";
    }


}
