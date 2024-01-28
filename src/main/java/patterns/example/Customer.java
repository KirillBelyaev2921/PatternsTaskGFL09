package patterns.example;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

// Remove logic for printing statement, add iterator for rental.
public class Customer implements Iterable<Rental>, Serializable {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Rental> iterator() {
        return rentals.iterator();
    }

    public Stream<Rental> stream() {
        return rentals.stream();
    }
}