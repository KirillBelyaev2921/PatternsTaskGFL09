package patterns.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static patterns.example.strategy.MovieType.*;

class CustomerTest {

	@Test
	void testStatement() {
		List<Rental> rentals = List.of(new Rental(Movie.getBuilder().setTitle("Rambo")
						.setPriceCode(REGULAR).build(), 1),
				new Rental(Movie.getBuilder().setTitle("Lord of the Rings")
						.setPriceCode(NEW_RELEASE).build(), 4),
				new Rental(Movie.getBuilder().setTitle("Harry Potter")
						.setPriceCode(CHILDREN).build(), 5));


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