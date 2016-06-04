package imaginary.videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Movie regularMovie1;
    private Movie regularMovie2;
    private Movie childrenMovie;
    private Movie newReleaseMovie;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        regularMovie1 = new Movie("Regular 1", Movie.REGULAR);
        regularMovie2 = new Movie("Regular 2", Movie.REGULAR);
        childrenMovie = new Movie("Children", Movie.CHILDRENS);
        newReleaseMovie = new Movie("New Release", Movie.NEW_RELEASE);
        customer = new Customer("Customer");
    }

    @Test
    public void statement_NoRentals() {
        String expectedStatement = "Rental Record for Customer\n"
                + "Amount owed is 0.0\n"
                + "You earned 0 frequent renter points";
        assertEquals("should generate 'empty' statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneRegularMovieTwoDays() {
        customer.addRental(new Rental(regularMovie1, 2));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tRegular 1\t2.0\n"
                + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneRegularMovieThreeDays() {
        customer.addRental(new Rental(regularMovie1, 3));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tRegular 1\t3.5\n"
                + "Amount owed is 3.5\n"
                + "You earned 1 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneRegularMovieFourDays() {
        customer.addRental(new Rental(regularMovie1, 4));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tRegular 1\t5.0\n"
                + "Amount owed is 5.0\n"
                + "You earned 1 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_TwoRegularMovies() {
        customer.addRental(new Rental(regularMovie1, 2));
        customer.addRental(new Rental(regularMovie2, 3));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tRegular 1\t2.0\n"
                + "\tRegular 2\t3.5\n"
                + "Amount owed is 5.5\n"
                + "You earned 2 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneNewReleaseOneDay() {
        customer.addRental(new Rental(newReleaseMovie, 1));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tNew Release\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneNewReleaseTwoDays() {
        customer.addRental(new Rental(newReleaseMovie, 2));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tNew Release\t6.0\n"
                + "Amount owed is 6.0\n"
                + "You earned 2 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneChildrenThreeDays() {
        customer.addRental(new Rental(childrenMovie, 3));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tChildren\t1.5\n"
                + "Amount owed is 1.5\n"
                + "You earned 1 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneChildrenFourDays() {
        customer.addRental(new Rental(childrenMovie, 4));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tChildren\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_OneChildrenFiveDays() {
        customer.addRental(new Rental(childrenMovie, 5));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tChildren\t4.5\n"
                + "Amount owed is 4.5\n"
                + "You earned 1 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

    @Test
    public void statement_someRentals() {
        customer.addRental(new Rental(regularMovie1, 2));
        customer.addRental(new Rental(regularMovie2, 3));
        customer.addRental(new Rental(newReleaseMovie, 3));
        customer.addRental(new Rental(childrenMovie, 5));
        String expectedStatement = "Rental Record for Customer\n"
                + "\tRegular 1\t2.0\n"
                + "\tRegular 2\t3.5\n"
                + "\tNew Release\t9.0\n"
                + "\tChildren\t4.5\n"
                + "Amount owed is 19.0\n"
                + "You earned 5 frequent renter points";
        assertEquals("generates wrong statment.", expectedStatement, customer.statement());
    }

}