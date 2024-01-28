package patterns.example.template;

import patterns.example.Customer;

public class HtmlCustomerPrinter extends StringCustomerPrinter {
	public HtmlCustomerPrinter(Customer customer) {
		super(customer);
	}

	@Override
	protected String header() {
		return """
				<!DOCTYPE html>
				<html>
				<body>
				""" + super.header();
	}

	@Override
	protected String tail() {
		return super.tail() + """
				</body>
				</html>""";
	}

	@Override
	protected String lineSeparator() {
		return "<p>";
	}


}
