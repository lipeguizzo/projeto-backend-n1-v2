package br.com.exercicio10.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}
