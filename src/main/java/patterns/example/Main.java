package patterns.example;

import patterns.example.template.StringCustomerPrinter;

import java.util.List;

import static patterns.example.strategy.MovieType.*;

public class Main {

	public static void main(String[] args) {
		List<Rental> rentals = List.of(new Rental(Movie.getBuilder().setTitle("Rambo")
						.setPriceCode(REGULAR).build(), 1),
				new Rental(Movie.getBuilder().setTitle("Lord of the Rings")
						.setPriceCode(NEW_RELEASE).build(), 4),
				new Rental(Movie.getBuilder().setTitle("Harry Potter")
						.setPriceCode(CHILDREN).build(), 5));

		Customer customer = new Customer("John Doe", rentals);
		String statement = new StringCustomerPrinter(customer).statement();

		System.out.println(statement);
	}
}