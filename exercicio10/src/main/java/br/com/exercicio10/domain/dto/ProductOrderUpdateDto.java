package br.com.exercicio10.domain.dto;

import br.com.exercicio10.domain.entities.Order;
import br.com.exercicio10.domain.entities.Product;
import jakarta.validation.constraints.NotNull;

public record ProductOrderUpdateDto(
        @NotNull(message = "Produto obrigatorio!")
        Product product,
        @NotNull(message = "Pedido obrigatorio!")
        Order order,
        @NotNull(message = "Quantidade obrigatorio!")
        Double amount
        ) { }
