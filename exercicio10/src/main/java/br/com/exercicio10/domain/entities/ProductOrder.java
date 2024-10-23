package br.com.exercicio10.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductOrder {
    private String id;
    private Product product;
    private Order order;
    private Double amount;
}
