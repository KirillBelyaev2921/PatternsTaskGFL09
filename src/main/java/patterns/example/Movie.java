package patterns.example;

import patterns.example.strategy.MovieType;

public class Movie {
    private final String title;
    private final MovieType priceCode;
    private final String movieGenre;
    private final String country;
    private final String description;
    private final String director;
    private final String actors;

    private Movie(String title, MovieType priceCode,
                  String movieGenre, String country,
                  String description, String director, String actors) {
        this.title = title;
        this.priceCode = priceCode;
        this.movieGenre = movieGenre;
        this.country = country;
        this.description = description;
        this.director = director;
        this.actors = actors;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public static MovieBuilder getBuilder() {
        return new MovieBuilder();
    }

    public static class MovieBuilder {
        private String title;
        private MovieType priceCode;
        private String movieGenre;
        private String country;
        private String description;
        private String director;
        private String actors;

        public MovieBuilder() {
        }

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setPriceCode(MovieType priceCode) {
            this.priceCode = priceCode;
            return this;
        }

        public MovieBuilder setMovieGenre(String movieGenre) {
            this.movieGenre = movieGenre;
            return this;
        }

        public MovieBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public MovieBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MovieBuilder setDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder setActors(String actors) {
            this.actors = actors;
            return this;
        }

        public Movie build() {
            return new Movie(title, priceCode, movieGenre,
                    country, description, director, actors);
        }
    }
}