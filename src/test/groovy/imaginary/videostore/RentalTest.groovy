package imaginary.videostore

import imaginary.videostore.movie.Movie
import spock.lang.Specification

class RentalTest extends Specification {

    def 'getMovie should return the movie'() {
        given:
        Movie movie1 = Mock()
        Movie movie2 = Mock()

        expect:
        new Rental(movie1, 0).getMovie() == movie1
        new Rental(movie2, 0).getMovie() == movie2
    }

    def 'calculateAmount works correctly'() {
        given:
        Movie movie = Mock()
        movie.calculateAmount(rentalDays) >> rentalDays * 2

        def rental = new Rental(movie, rentalDays)

        expect:
        rental.calculateAmount() == rentalDays * 2

        where:
        rentalDays << [0, 2, 5, 10, 100]
    }

    def 'calculateFrequentRenterPoints works correctly'() {
        given:
        Movie movie = Mock()
        movie.calculateAdditionalFrequentRenterPoints(rentalDays) >> rentalDays

        def rental = new Rental(movie, rentalDays)

        expect:
        rental.calculateFrequentRenterPoints() == frequentRenterPoints

        where:
        rentalDays | frequentRenterPoints
        0          | 1
        1          | 2
        2          | 3
        3          | 4
        5          | 6
    }
}
