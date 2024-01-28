package patterns.example.template;

import patterns.example.Customer;
import patterns.example.Rental;

// Template-servant-strategy for customer to generate appropriate
// custom String representation of customer.
// Does not "print" anything to console or anywhere, but only gives result String.
public abstract class CustomerPrinter {
	private final StringBuilder result = new StringBuilder();
	private final Customer customer;
	private double totalAmount;
	private int frequentRenterPoints;

	public CustomerPrinter(Customer customer) {
		this.customer = customer;
	}

	public String statement() {
		result.append(header())
				.append(body())
				.append(tail());
		return result.toString();
	}

	protected abstract String header();

	protected abstract String tail();

	protected final String getCustomerName() {
		return customer.getName();
	}

	private String body() {
		StringBuilder mainBody = new StringBuilder();
		totalAmount = 0;
		frequentRenterPoints = 0;
		for (Rental each : customer) {
			double thisAmount = each.getPriceForMovie();
			// add frequent renter points
			frequentRenterPoints++;
			frequentRenterPoints += each.getFrequentRenterPoint();

			//show figures for this rental
			mainBody.append("\t")
					.append(each.getMovie().getTitle())
					.append("\t")
					.append(thisAmount)
					.append(lineSeparator());
			totalAmount += thisAmount;
		}
		return mainBody.toString();
	}

	protected abstract String lineSeparator();

	protected double getTotalAmount() {
		return totalAmount;
	}

	protected int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}
}
