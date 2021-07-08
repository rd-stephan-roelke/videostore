package imaginary.videostore;

import imaginary.videostore.movie.Movie;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateAmount() {
        return movie.calculateAmount(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return 1 + movie.calculateAdditionalFrequentRenterPoints(daysRented);
    }
}