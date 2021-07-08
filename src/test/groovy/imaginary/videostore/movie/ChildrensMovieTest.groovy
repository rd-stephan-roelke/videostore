package imaginary.videostore.movie

import spock.lang.Specification
import spock.lang.Subject


class ChildrensMovieTest extends Specification {

    @Subject
    ChildrensMovie movie

    def setup() {
        movie = new ChildrensMovie('new release')
    }

    def 'getTitle should return movie title'() {
        given:
        def title1 = 'Movie1'
        def title2 = 'ChildrensMovie'

        expect:
        new ChildrensMovie(title1).getTitle() == title1
        new ChildrensMovie(title2).getTitle() == title2
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
        0          | 1.5
        1          | 1.5
        2          | 1.5
        3          | 1.5
        5          | 4.5
    }
}
