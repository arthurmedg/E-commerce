package com.biolab.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private String imgUrl;

//    fazendo tabela intermediaria
    @ManyToMany
    @JoinTable(name = "produto_categoria", // criação da tabela intermediaria juntando produto e categoria e atribuindo seu nome de produto_categoria
    joinColumns = @JoinColumn(name="produto_id"), // primeira tabela
    inverseJoinColumns = @JoinColumn(name = "categoria_id")) // segunda tabela - inverseJoinColumns utilizado por ser a segunda coluna
    private Set<Categoria> categorias = new HashSet<>();


}
