package com.biolab.ecommerce.entities;

import com.biolab.ecommerce.entities.enums.Role;
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
// @Getter - cria apenas os getters
// @Setter - cria apenas os setters

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
    @Column(length = 20)
    private String telefone;
    @NotBlank @Size(min = 6)
    private String senha;
    @Enumerated(EnumType.STRING)
    private Role roles;

}
