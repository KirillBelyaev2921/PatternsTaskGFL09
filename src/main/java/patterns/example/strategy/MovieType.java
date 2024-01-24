package patterns.example.strategy;

public interface MovieType {
	MovieType REGULAR = new Regular();
	MovieType CHILDREN = new Children();
	MovieType NEW_RELEASE = new NewRelease();
	double getPriceForMovie(int daysRented);
	int getFrequentRenterPoint(int daysRented);
}
