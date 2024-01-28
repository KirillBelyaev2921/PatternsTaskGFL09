package patterns.example;

import patterns.example.template.StringCustomerPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static patterns.example.strategy.MovieType.*;

public class Main {
	MovieCatalog movies = new MovieCatalog();
	List<Customer> customers = new ArrayList<>();

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("dat.dat"))) {
			Data data = FileHandler.getDataFromFile(in);
			movies = data.movies();
			customers = data.customers();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		Customer customer = customers.get(0);
		String statement = new StringCustomerPrinter(customer).statement();
		System.out.println(statement);
	}

	private void run1() {
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
		customers.add(customer);
		String statement = new StringCustomerPrinter(customer).statement();

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dat.dat"))) {
			FileHandler.saveDataToFile(out, new Data(movies, customers));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println(statement);
	}

}