package imaginary.videostore.movie;

public class ChildrensMovie extends BaseMovie {

    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        var amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }
}
