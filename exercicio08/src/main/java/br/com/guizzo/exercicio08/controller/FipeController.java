package br.com.guizzo.exercicio08.controller;

import br.com.guizzo.exercicio08.domain.dto.FipeCreateDto;
import br.com.guizzo.exercicio08.domain.dto.FipeModeloResponseDto;
import br.com.guizzo.exercicio08.domain.dto.FipeValorResponseDto;
import br.com.guizzo.exercicio08.domain.entity.Ano;
import br.com.guizzo.exercicio08.domain.entity.Marca;
import br.com.guizzo.exercicio08.domain.entity.Modelo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;

@RestController
@RequestMapping("/fipe")
public class FipeController {
    private RestClient client = RestClient.create("https://parallelum.com.br/fipe/api/v1/carros/");

    @PostMapping("/valor")
    public ResponseEntity<?> createValor(@RequestBody FipeCreateDto dto) {
        try {
            ArrayList<Marca> marcasList = client
                    .get()
                    .uri("marcas" )
                    .retrieve()
                    .body(new ParameterizedTypeReference<ArrayList<Marca>>() {});

            if (marcasList == null) {
                return ResponseEntity.badRequest().body("Nenhuma marca encontrada!");
            }

            Marca marcaSelecionada = null;
            for (Marca marca : marcasList) {
                if (marca.getNome() == null) {
                    continue;
                }
                if (marca.getNome().equalsIgnoreCase(dto.marca())) {
                    marcaSelecionada = marca;
                    break;
                }
            }

            if (marcaSelecionada == null) {
                return ResponseEntity.badRequest().body("Nenhuma marca encontrada!");
            }

            FipeModeloResponseDto modelosList = client
                    .get()
                    .uri("marcas/" + marcaSelecionada.getCodigo() + "/modelos" )
                    .retrieve()
                    .body(FipeModeloResponseDto.class);

            if (modelosList == null) {
                return ResponseEntity.badRequest().body("Nenhum modelo encontrado!");
            }

            Modelo modeloSelecionado = null;
            for (Modelo modelo : modelosList.modelos()) {
                if (modelo.getNome().equalsIgnoreCase(dto.modelo())) {
                    modeloSelecionado = modelo;
                    break;
                }
            }

            if (modeloSelecionado == null) {
                return ResponseEntity.badRequest().body("Nenhum modelo encontrado!");
            }

            ArrayList<Ano> anosList = client
                    .get()
                    .uri("marcas/" + marcaSelecionada.getCodigo() + "/modelos/" + modeloSelecionado.getCodigo() + "/anos" )
                    .retrieve()
                    .body(new ParameterizedTypeReference<ArrayList<Ano>>() {});

            if (anosList == null) {
                return ResponseEntity.badRequest().body("Nenhum ano encontrado!");
            }

            Ano anoSelecionado = null;
            for (Ano ano : anosList) {
                if (ano.getNome().equalsIgnoreCase(dto.ano().toString())) {
                    anoSelecionado = ano;
                    break;
                }
            }

            if (anoSelecionado == null) {
                return ResponseEntity.badRequest().body("Nenhum ano encontrado!");
            }

            FipeValorResponseDto data = client
                    .get()
                    .uri("marcas/" + marcaSelecionada.getCodigo() + "/modelos/" + modeloSelecionado.getCodigo() + "/anos/" + anoSelecionado.getCodigo())
                    .retrieve()
                    .body(FipeValorResponseDto.class);

            return ResponseEntity.ok(data);
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error);
        }
    }
}
