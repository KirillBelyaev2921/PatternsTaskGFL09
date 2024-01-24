package patterns.example.strategy;

public class Regular implements MovieType {

	@Override
	public double getPriceForMovie(int daysRented) {
		double result = 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}

	@Override
	public int getFrequentRenterPoint(int daysRented) {
		return 0;
	}
}
