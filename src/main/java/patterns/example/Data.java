package patterns.example;

import java.io.Serializable;
import java.util.List;

public record Data(MovieCatalog movies, List<Customer> customers) implements Serializable {
}
