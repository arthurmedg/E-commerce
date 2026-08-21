package com.biolab.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// substitui os getters e setters
@Data
// substitui o construtor com todos os argumentos
@AllArgsConstructor
// substitui o construtor vazio
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    @Column(length = 150)
    private String email;
    private String telefone;
    @NotBlank @Size(min = 6)
    @Column(length = 150)
    private String senha;
    private String[] roles;


}
