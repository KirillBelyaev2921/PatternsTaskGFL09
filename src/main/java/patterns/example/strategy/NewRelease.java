package patterns.example.strategy;

import java.io.Serializable;

public class NewRelease implements MovieType, Serializable {
	@Override
	public double getPriceForMovie(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoint(int daysRented) {
		return (daysRented > 1) ? 1 : 0;
	}
}
