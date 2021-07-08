package imaginary.videostore

import imaginary.videostore.movie.ChildrensMovie
import imaginary.videostore.movie.NewReleaseMovie
import imaginary.videostore.movie.RegularMovie
import spock.lang.Specification
import spock.lang.Subject

class CustomerTest extends Specification {

    @Subject
    private Customer customer

    def regularMovie1 = new RegularMovie('Regular 1')
    def regularMovie2 = new RegularMovie('Regular 2')
    def childrenMovie = new ChildrensMovie('Children')
    def newReleaseMovie = new NewReleaseMovie('New Release')

    def setup() {
        customer = new Customer('Customer')
    }

    def 'statement should generate empty statment'() {
        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                'Amount owed is 0.0\n' +
                'You earned 0 frequent renter points'
    }

    def 'statement one regular movie two days'() {
        given:
        customer.addRental(new Rental(regularMovie1, 2))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tRegular 1\t2.0\n' +
                'Amount owed is 2.0\n' +
                'You earned 1 frequent renter points'
    }

    def 'statement one regular movie three days'() {
        given:
        customer.addRental(new Rental(regularMovie1, 3))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tRegular 1\t3.5\n' +
                'Amount owed is 3.5\n' +
                'You earned 1 frequent renter points'
    }

    def 'statement one regular movie four days'() {
        given:
        customer.addRental(new Rental(regularMovie1, 4))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tRegular 1\t5.0\n' +
                'Amount owed is 5.0\n' +
                'You earned 1 frequent renter points'
    }

    def 'statement one regular movies'() {
        given:
        customer.addRental(new Rental(regularMovie1, 2))
        customer.addRental(new Rental(regularMovie2, 3))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tRegular 1\t2.0\n' +
                '\tRegular 2\t3.5\n' +
                'Amount owed is 5.5\n' +
                'You earned 2 frequent renter points'
    }

    def 'statement one new release one day'() {
        given:
        customer.addRental(new Rental(newReleaseMovie, 1))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tNew Release\t3.0\n' +
                'Amount owed is 3.0\n' +
                'You earned 1 frequent renter points'
    }

    def 'statement one new release two days'() {
        given:
        customer.addRental(new Rental(newReleaseMovie, 2))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tNew Release\t6.0\n' +
                'Amount owed is 6.0\n' +
                'You earned 2 frequent renter points'
    }

    def 'statement one children three days'() {
        given:
        customer.addRental(new Rental(childrenMovie, 3))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tChildren\t1.5\n' +
                'Amount owed is 1.5\n' +
                'You earned 1 frequent renter points'
    }

    def 'statement one children four days'() {
        given:
        customer.addRental(new Rental(childrenMovie, 4))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tChildren\t3.0\n' +
                'Amount owed is 3.0\n' +
                'You earned 1 frequent renter points'
    }

    def 'statement one children five days'() {
        given:
        customer.addRental(new Rental(childrenMovie, 5))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tChildren\t4.5\n' +
                'Amount owed is 4.5\n' +
                'You earned 1 frequent renter points'
    }

    def 'statement some rentals'() {
        given:
        customer.addRental(new Rental(regularMovie1, 2))
        customer.addRental(new Rental(regularMovie2, 3))
        customer.addRental(new Rental(newReleaseMovie, 3))
        customer.addRental(new Rental(childrenMovie, 5))

        when:
        def result = customer.statement()

        then:
        result == 'Rental Record for Customer\n' +
                '\tRegular 1\t2.0\n' +
                '\tRegular 2\t3.5\n' +
                '\tNew Release\t9.0\n' +
                '\tChildren\t4.5\n' +
                'Amount owed is 19.0\n' +
                'You earned 5 frequent renter points'
    }
}
