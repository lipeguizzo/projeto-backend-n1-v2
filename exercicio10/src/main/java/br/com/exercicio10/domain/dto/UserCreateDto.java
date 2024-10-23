package br.com.exercicio10.domain.dto;

import jakarta.validation.constraints.NotNull;

public record UserCreateDto(
        @NotNull(message = "Nome obrigatorio!")
        String name,
        @NotNull(message = "E-mail obrigatorio!")
        String email,
        @NotNull(message = "Senha obrigatorio!")
        String password
        ) { }
