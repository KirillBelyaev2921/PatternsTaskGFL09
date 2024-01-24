package patterns.example.strategy;

public class NewRelease implements MovieType {
	@Override
	public double getPriceForMovie(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoint(int daysRented) {
		return (daysRented > 1) ? 1 : 0;
	}
}
