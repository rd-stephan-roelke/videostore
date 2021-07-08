package imaginary.videostore.movie;

public class RegularMovie extends BaseMovie {

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}
