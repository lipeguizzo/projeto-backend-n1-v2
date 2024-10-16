package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ambiance = 0, gender = 0;

        try {
        System.out.println("Qual ambientação de filmes você prefere?");
        System.out.print("1 - Neve\n2 - Espaço\nEscolha: ");
        ambiance = scan.nextInt();

        System.out.println("Qual gênero de filmes você prefere?");
        System.out.print("1 - Terror\n2 - Aventura\nEscolha: ");
        gender = scan.nextInt();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        boolean isPanicSnow = ambiance == 1 && gender == 1;
        boolean isFrozen = ambiance == 1 && gender == 2;
        boolean isAlien = ambiance == 2 && gender == 1;
        boolean isStarWars = ambiance == 2 && gender == 2;

        if(ambiance < 1 || ambiance > 2) {
            System.out.println("Ambientação inválida!");
        }

        if(gender < 1 || ambiance > 2) {
            System.out.println("Gênero inválido!");
        }

        if(isPanicSnow){
            System.out.println("Filme gerado: Pânico na Neve!");
        }

        if(isFrozen){
            System.out.println("Filme gerado: Frozen!");
        }

        if(isAlien){
            System.out.println("Filme gerado: Alien!");
        }

        if(isStarWars){
            System.out.println("Filme gerado: Star Wars!");
        }

    }
}