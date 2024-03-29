package patterns.example;


import java.io.Serializable;

public class Rental implements Serializable {
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
        return movie.getPriceCode()
                .getPriceForMovie(daysRented);
    }

    public int getFrequentRenterPoint() {
        return movie.getPriceCode()
                .getFrequentRenterPoint(daysRented);
    }
}
