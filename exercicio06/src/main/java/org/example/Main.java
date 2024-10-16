package org.example;

import org.example.entity.Cinema;
import org.example.entity.Client;
import org.example.entity.Movie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.addMovie(new Movie("Miranha 2", 10.0, 12));
        cinema.addMovie(new Movie("Batman", 12.5, 16));
        cinema.addMovie(new Movie("Jogo Justo", 15.0, 18));
        cinema.addMovie(new Movie("Frozen", 20.0, 10));
        cinema.addMovie(new Movie("Alien", 25.0, 14));

        Scanner scanner = new Scanner(System.in);

        for(Movie movie : cinema.getAvailableMovies()){
            System.out.println(movie.getName() + " - " + movie.getPrice());
        }
        while (true){

        try {
            System.out.println("Digite seu nome:");
            String clientName = scanner.nextLine();

            System.out.println("Digite sua idade:");
            int clientAge = scanner.nextInt();
            scanner.nextLine();

            Client client = new Client(clientName, clientAge);

            System.out.println("Digite o nome do filme:");
            String movieName = scanner.nextLine();

            System.out.println("Digite o acento (A1, B3, ...):");
            String seat = scanner.nextLine();

            if (cinema.sellTicket(client, movieName, seat)) {
                System.out.println("Ingresso vendido com sucesso! " + movieName + " - " + seat + " - " + clientName );
            }

            System.out.println("Deseja continuar? 1 - SIM , 2 - NÃO:");
            int continueValue = scanner.nextInt();

            if(continueValue == 2){
                break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            }
        }
    }
}
