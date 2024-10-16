package br.com.guizzo.exercicio08.domain.dto;

import br.com.guizzo.exercicio08.domain.entity.Ano;
import br.com.guizzo.exercicio08.domain.entity.Modelo;

import java.util.ArrayList;

public record FipeModeloResponseDto(
        ArrayList<Modelo> modelos,
        ArrayList<Ano> anos
) {
}
