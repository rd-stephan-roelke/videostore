package imaginary.videostore.movie;

public class NewReleaseMovie extends BaseMovie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3.0;
    }

    @Override
    public int calculateAdditionalFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 1 : 0;
    }
}
