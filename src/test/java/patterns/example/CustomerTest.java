package patterns.example;

import org.junit.jupiter.api.Test;
import patterns.example.template.StringCustomerPrinter;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static patterns.example.strategy.MovieType.*;

class CustomerTest {
	MovieCatalog movies = new MovieCatalog();

	@Test
	void testStatement() {
		movies.addMovie(Movie.getBuilder().setTitle("Rambo")
				.setPriceCode(REGULAR).build());
		movies.addMovie(Movie.getBuilder().setTitle("Lord of the Rings")
				.setPriceCode(NEW_RELEASE).build());
		movies.addMovie(Movie.getBuilder().setTitle("Harry Potter")
				.setPriceCode(CHILDREN).build());
		List<Rental> rentals = List.of(new Rental(movies.findMovieByTitle("Rambo", ""), 1),
				new Rental(movies.findMovieByTitle("Lord of the Rings", ""), 4),
				new Rental(movies.findMovieByTitle("Harry Potter", ""), 5));

		Customer customer = new Customer("John Doe", rentals);
		String statement = new StringCustomerPrinter(customer).statement();

		assertThat(statement, equalTo("""
				Rental Record for John Doe
					Rambo	2.0
					Lord of the Rings	12.0
					Harry Potter	4.5
				Amount owed is 18.5
				You earned 4 frequent renter points
				"""));
	}
}