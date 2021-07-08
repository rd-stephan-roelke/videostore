package imaginary.videostore.movie

import spock.lang.Specification
import spock.lang.Subject

class RegularMovieTest extends Specification {

    @Subject
    RegularMovie movie

    def setup() {
        movie = new RegularMovie('regular movie')
    }

    def 'getTitle should return movie title'() {
        given:
        def title1 = 'Movie1'
        def title2 = 'RegularMovie'

        expect:
        new RegularMovie(title1).getTitle() == title1
        new RegularMovie(title2).getTitle() == title2
    }

    def 'calculateAdditionalFrequentRenterPoints should always return 0'() {
        expect:
        movie.calculateAdditionalFrequentRenterPoints(rentalDays) == 0

        where:
        rentalDays << [0, 2, 5, 10, 100]
    }

    def 'calculateAmount calculates correctly'() {
        expect:
        movie.calculateAmount(rentalDays) == amount

        where:
        rentalDays | amount
        0          | 2
        1          | 2
        2          | 2
        3          | 3.5
        5          | 6.5
    }
}
