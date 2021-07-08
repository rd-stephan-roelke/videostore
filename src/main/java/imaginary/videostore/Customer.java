package imaginary.videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental aRental) {
        rentals.add(aRental);
    }

    public String statement() {
        var totalAmount = 0.0;
        var frequentRenterPoints = 0;
        var result = new StringBuilder(String.format("Rental Record for %s\n", getName()));

        for(Rental each: rentals) {
            frequentRenterPoints += each.calculateFrequentRenterPoints();

            double thisAmount = each.calculateAmount();
            // show figures for this rental
            result.append(String.format("\t%s\t%s\n", each.getMovie().getTitle(), thisAmount));
            totalAmount += thisAmount;
        }

        // add footer lines
        result.append(String.format("Amount owed is %s\n", totalAmount));
        result.append(String.format("You earned %s frequent renter points", frequentRenterPoints));

        return result.toString();
    }

}