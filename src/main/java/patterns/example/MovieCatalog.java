package patterns.example;

import patterns.example.strategy.MovieType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MovieCatalog implements Iterable<Movie> {
	private final List<Movie> movies = new ArrayList<>();

	public List<Movie> getMovieList() {
		return movies;
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	public Movie findMovieByTitle(String title, String director) {
		return movies.stream()
				.filter(m -> m.getTitle().equals(title))
				.filter(m -> m.getDirector().equals(director))
				.findFirst().orElse(null);
	}

	public List<Movie> findMoviesByDirector(String title) {
		return movies.stream()
				.filter(m -> m.getDirector().equals(title))
				.toList();
	}

	public List<Movie> findMoviesByMovieType(MovieType movieType) {
		return movies.stream()
				.filter(m -> m.getPriceCode().getClass()
						== movieType.getClass())
				.toList();
	}
	public List<Movie> findMoviesByMovieGenre(String genre) {
		return movies.stream()
				.filter(m -> m.getMovieGenre().equals(genre))
				.toList();
	}

	@Override
	public Iterator<Movie> iterator() {
		return movies.iterator();
	}

	public Stream<Movie> stream() {
		return movies.stream();
	}
}
