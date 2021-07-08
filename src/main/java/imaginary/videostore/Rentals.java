package imaginary.videostore;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public double calculateTotalAmount() {
        return stream().mapToDouble(Rental::calculateAmount).sum();
    }

    public int calculateFrequentRenterPoints() {
        return stream().mapToInt(Rental::calculateFrequentRenterPoints).sum();
    }
}
