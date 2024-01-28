package patterns.example.template;

import patterns.example.Customer;

// Extends from StringCustomerPrinter, so it can use everything
// it generates, but with appropriate line separators. Not necessary,
// could also be extended from CustomerPrinter, if needed other string headers
// and tails.
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
