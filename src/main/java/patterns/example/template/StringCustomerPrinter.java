package patterns.example.template;

import patterns.example.Customer;
import patterns.example.Rental;

public class StringCustomerPrinter extends CustomerPrinter {
	public StringCustomerPrinter(Customer customer) {
		super(customer);
	}

	@Override
	protected String header() {
		return "Rental Record for " + getCustomerName() + lineSeparator();
	}

	@Override
	protected String tail() {
		String result = "";
		result += "Amount owed is " + getTotalAmount() + lineSeparator();
		result += "You earned " + getFrequentRenterPoints() + " frequent renter points"
				+ lineSeparator();
		return result;
	}

	@Override
	protected String lineSeparator() {
		return "\n";
	}

}
