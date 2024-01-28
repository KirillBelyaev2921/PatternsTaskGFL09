package patterns.example.template;

import patterns.example.Customer;
import patterns.example.Rental;

public abstract class CustomerPrinter {
	private final StringBuilder result = new StringBuilder();
	private final Customer customer;
	private double totalAmount;
	private int frequentRenterPoints;

	protected CustomerPrinter(Customer customer) {
		this.customer = customer;
	}

	public String statement() {
		result.append(addHeader());
		result.append(addMainBody());
		result.append(addTail());
		return result.toString();
	}

	protected abstract String addHeader();
	protected abstract String addTail();
	protected final String getCustomerName() {
		return customer.getName();
	}

	private String addMainBody() {
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
					.append("\n");
			totalAmount += thisAmount;
		}
		return mainBody.toString();
	}

	protected double getTotalAmount() {
		return totalAmount;
	}

	protected int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}
}
