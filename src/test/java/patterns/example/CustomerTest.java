package patterns.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static patterns.example.Movie.MovieType.*;

class CustomerTest {

	@Test
	void testStatement() {
		List<Rental> rentals = List.of(new Rental(new Movie("Rambo", REGULAR), 1),
				new Rental(new Movie("Lord of the Rings", NEW_RELEASE), 4),
				new Rental(new Movie("Harry Potter", CHILDRENS), 5));

		Customer customer = new Customer("John Doe", rentals);
		String statement = customer.statement();

		assertThat(statement, equalTo("""
				Rental Record for John Doe
					Rambo	2.0
					Lord of the Rings	12.0
					Harry Potter	4.5
				Amount owed is 18.5
				You earned 4 frequent renter points"""));
	}
}