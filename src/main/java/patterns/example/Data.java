package patterns.example;

import java.io.Serializable;
import java.util.List;

// Just holder for catalog and customers. Same as serializing Main class.
public record Data(MovieCatalog movies, List<Customer> customers) implements Serializable {
}
