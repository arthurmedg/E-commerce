package com.biolab.ecommerce.DTOs;

import com.biolab.ecommerce.entities.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    private long id;
    @NotBlank
    private String nome;
    private String descricao;
    @NotNull
    private double preco;
    private String imgUrl;
    private long idCategoria;
    private Set<Categoria> categoriaList;

    public ProdutoDTO(String nome, String descricao, double preco, String imgUrl, long idCategoria, Set<Categoria> categoriaList) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
        this.idCategoria = idCategoria;
        this.categoriaList = categoriaList;
    }

    public ProdutoDTO(String nome, String descricao, double preco, String imgUrl, long idCategoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
        this.idCategoria = idCategoria;
    }

    public ProdutoDTO(String nome, String descricao, double preco, String imgUrl, Set<Categoria> categoriaList) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
        this.categoriaList = categoriaList;
    }
}
