package br.com.exercicio10.domain.dto;

import br.com.exercicio10.domain.entities.User;
import jakarta.validation.constraints.NotNull;

public record OrderCreateDto(
        @NotNull(message = "Usuário obrigatorio!")
        User user,
        @NotNull(message = "Total obrigatorio!")
        Double total
        ) { }
