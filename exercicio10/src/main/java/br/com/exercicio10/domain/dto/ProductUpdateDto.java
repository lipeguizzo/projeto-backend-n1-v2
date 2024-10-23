package br.com.exercicio10.domain.dto;

import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto(
        @NotNull(message = "Nome obrigatorio!")
        String name,
        @NotNull(message = "Descrição obrigatoria!")
        String description,
        @NotNull(message = "Preço obrigatorio!")
        Double price,
        @NotNull(message = "Estoque obrigatorio!")
        Integer stock
        ) { }
