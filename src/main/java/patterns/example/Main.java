package patterns.example;

import patterns.example.template.StringCustomerPrinter;

import java.util.List;

import static patterns.example.strategy.MovieType.*;

public class Main {
	MovieCatalog movies = new MovieCatalog();

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
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

		System.out.println(statement);
	}

}