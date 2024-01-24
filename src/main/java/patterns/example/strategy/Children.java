package patterns.example.strategy;

public class Children implements MovieType {

	@Override
	public double getPriceForMovie(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}

	@Override
	public int getFrequentRenterPoint(int daysRented) {
		return 0;
	}
}
