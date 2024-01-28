package patterns.example.strategy;

// Strategy to define price for movie and points by days rented
public interface MovieType {
	/* Simple singletons to get movie types. Because these types don't need
	   any state, make singleton from them.
	*/
	MovieType REGULAR = new Regular();
	MovieType CHILDREN = new Children();
	MovieType NEW_RELEASE = new NewRelease();

	double getPriceForMovie(int daysRented);
	int getFrequentRenterPoint(int daysRented);
}
