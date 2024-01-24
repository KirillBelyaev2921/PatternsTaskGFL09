package patterns.example;

import static patterns.example.Movie.MovieType.NEW_RELEASE;

class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPriceForMovie() {
        double result = 0;
        switch (movie.getPriceCode()) {
            case REGULAR -> {
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
            }
            case NEW_RELEASE -> result += daysRented * 3;
            case CHILDRENS -> {
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
            }
        }
        return result;
    }

    public int getFrequentRenterPoint() {
        return (movie.getPriceCode() == NEW_RELEASE)
                && (daysRented > 1)
                ? 1 : 0;
    }
}
