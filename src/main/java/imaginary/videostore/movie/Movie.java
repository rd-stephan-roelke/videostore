package imaginary.videostore.movie;

public interface Movie {
    String getTitle();

    double calculateAmount(int daysRented);

    int calculateAdditionalFrequentRenterPoints(int daysRented);
}
