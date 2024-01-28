package patterns.example.template;

import patterns.example.Customer;

public class StringCustomerPrinter extends CustomerPrinter {
	public StringCustomerPrinter(Customer customer) {
		super(customer);
	}

	@Override
	protected String addHeader() {
		return "Rental Record for " + getCustomerName() + "\n";
	}

	@Override
	protected String addTail() {
		String result = "";
		result += "Amount owed is " + getTotalAmount() + "\n";
		result += "You earned " + getFrequentRenterPoints() + " frequent renter points";
		return result;
	}
}
