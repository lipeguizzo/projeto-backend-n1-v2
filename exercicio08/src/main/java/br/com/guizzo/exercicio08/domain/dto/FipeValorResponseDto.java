package br.com.guizzo.exercicio08.domain.dto;

public record FipeValorResponseDto(
        int TipoVeiculo,
        String Valor,
        String Marca,
        String Modelo,
        int AnoModelo,
        String Combustivel,
        String CodigoFipe,
        String MesReferencia,
        String SiglaCombustivel
) {
}
