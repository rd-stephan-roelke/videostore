package imaginary.videostore;

public class Customer {

    private final String name;
    private final Rentals rentals = new Rentals();

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
        //header
        var result = new StringBuilder(String.format("Rental Record for %s\n", getName()));
        //movies
        rentals.forEach(rental -> result.append(String.format("\t%s\t%s\n", rental.getMovie().getTitle(), rental.calculateAmount())));
        // footer
        result.append(String.format("Amount owed is %s\n", rentals.calculateTotalAmount()));
        result.append(String.format("You earned %s frequent renter points", rentals.calculateFrequentRenterPoints()));

        return result.toString();
    }

    public String htmlOutput() {
        //header
        var result = new StringBuilder(String.format("<h1>Rental Record for %s</h1>", getName()));
        //movies
        result.append("<table>");
        result.append("<tr><th>Movie</th><th>Amount</th></tr>");
        rentals.forEach(rental -> result.append(String.format("<tr><td>%s</td><td>%s</td></tr>", rental.getMovie().getTitle(), rental.calculateAmount())));
        result.append("</table>");
        // footer
        result.append(String.format("<p>Amount owed is %s</p>", rentals.calculateTotalAmount()));
        result.append(String.format("<p>You earned %s frequent renter points</p>", rentals.calculateFrequentRenterPoints()));

        return result.toString();
    }
}