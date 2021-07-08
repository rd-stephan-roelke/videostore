package imaginary.videostore.movie;

abstract class BaseMovie implements Movie {

    private final String title;

    protected BaseMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int calculateAdditionalFrequentRenterPoints(int daysRented) {
        return 0;
    }
}