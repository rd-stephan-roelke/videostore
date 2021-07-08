package imaginary.videostore.movie

import spock.lang.Specification
import spock.lang.Subject


class NewReleaseMovieTest extends Specification {

    @Subject
    NewReleaseMovie movie

    def setup() {
        movie = new NewReleaseMovie('new release')
    }

    def 'getTitle should return movie title'() {
        given:
        def title1 = 'Movie1'
        def title2 = 'NewReleaseMovie'

        expect:
        new NewReleaseMovie(title1).getTitle() == title1
        new NewReleaseMovie(title2).getTitle() == title2
    }

    def 'calculateAdditionalFrequentRenterPoints calculates correctly'() {
        expect:
        movie.calculateAdditionalFrequentRenterPoints(rentalDays) == frequentRenterPoints

        where:
        rentalDays | frequentRenterPoints
        0          | 0
        2          | 1
        5          | 1
        10         | 1
        100        | 1
    }

    def 'calculateAmount calculates correctly'() {
        expect:
        movie.calculateAmount(rentalDays) == amount

        where:
        rentalDays | amount
        0          | 0
        1          | 3
        2          | 6
        3          | 9
        5          | 15
    }
}
