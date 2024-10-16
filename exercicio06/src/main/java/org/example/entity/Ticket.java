package org.example.entity;

public class Ticket {
    private Client client;
    private Movie movie;
    private String seat;

    public Ticket() {
    }

    public Ticket(Client client, Movie movie, String seat) {
        this.client = client;
        this.movie = movie;
        this.seat = seat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
