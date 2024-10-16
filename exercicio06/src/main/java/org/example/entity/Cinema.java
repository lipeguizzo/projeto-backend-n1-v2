package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Movie> availableMovies;
    private List<Ticket> soldTickets;
    private List<String> availableSeats;

    public Cinema() {
        this.availableMovies = new ArrayList<>();
        this.soldTickets = new ArrayList<>();
        this.availableSeats = new ArrayList<>();
        populateSeats();
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public void setAvailableMovies(List<Movie> availableMovies) {
        this.availableMovies = availableMovies;
    }

    public List<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(List<Ticket> soldTickets) {
        this.soldTickets = soldTickets;
    }

    public List<String> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<String> availableSeats) {
        this.availableSeats = availableSeats;
    }

    private void populateSeats() {
        for (char row = 'A'; row <= 'F'; row++) {
            for (int number = 1; number <= 5; number++) {
                availableSeats.add(row + Integer.toString(number));
            }
        }
    }

    public void addMovie(Movie movie) {
        availableMovies.add(movie);
    }

    public Movie findMovieByName(String movieName) {
        for (Movie movie : availableMovies) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public boolean sellTicket(Client client, String movieName, String seat) throws Exception {
        Movie movie = findMovieByName(movieName);
        if (movie == null) {
            throw new Exception("Filme não encontrado!");
        }
        if (client.getAge() < movie.getMinAge()) {
            throw new Exception("Cliente não tem idade minima para este filme!");
        }
        if (!availableSeats.contains(seat)) {
            throw new Exception("Acento está disponivel!");
        }
        Ticket ticket = new Ticket(client, movie, seat);
        soldTickets.add(ticket);
        availableSeats.remove(seat);
        return true;
    }

}
