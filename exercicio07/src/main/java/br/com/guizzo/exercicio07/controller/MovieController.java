package br.com.guizzo.exercicio07.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @GetMapping("recomendar")
    public String findMovie(@RequestParam("gender") String gender, @RequestParam("ambiance") String ambiance){
        boolean isPanicSnow = ambiance.equalsIgnoreCase("Neve") && gender.equalsIgnoreCase("Terror");
        boolean isFrozen = ambiance.equalsIgnoreCase("Neve") && gender.equalsIgnoreCase("Aventura");
        boolean isAlien = ambiance.equalsIgnoreCase("Espaço") && gender.equalsIgnoreCase("Terror");
        boolean isStarWars = ambiance.equalsIgnoreCase("StarWars") && gender.equalsIgnoreCase("Aventura");

        if(isPanicSnow){
            return "Filme gerado: Pânico na Neve!";
        }

        if(isFrozen){
            return "Filme gerado: Frozen!";
        }

        if(isAlien){
            return "Filme gerado: Alien!";
        }

        if(isStarWars){
            return "Filme gerado: Star Wars!";
        }

        return "Ambientação ou Gênero inválido!";

    }
}
