import java.math.BigDecimal;
import java.util.Scanner;

public class Cash extends Purchase {

	/**
	 * Prompts the user for cash needed, and asks for the difference if amount given
	 * is not enough. Returns info to print on receipt.
	 */

	@Override
	public String purchase(Scanner scan, BigDecimal totalCost) {
		// inform the user of the total cost, to help user determine how much their
		// paying in cash.
		System.out.printf("Your total today is: $%.2f \n", totalCost);

		double userCash = Validator.getDouble(scan, "How much are you paying in cash?");

		// Check if user amount is enough, and prompt if they need to pay more.
		BigDecimal amountLacking = (totalCost.subtract(new BigDecimal(userCash)));

		while (amountLacking.compareTo(new BigDecimal(0)) == 1) {
			System.out.printf("Insufficent amount, more cash necessary. You need $%.2f \n", amountLacking);
			userCash += Validator.getDouble(scan, "How much are you adding?");
			amountLacking = (totalCost.subtract(new BigDecimal(userCash)));
		}
		return String.format("Your change is: $%.2f", new BigDecimal(userCash).subtract(totalCost));

	}

}
