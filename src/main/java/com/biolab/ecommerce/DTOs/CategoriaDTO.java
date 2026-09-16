package com.biolab.ecommerce.DTOs;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private long id;
    private String nome;

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }
}
