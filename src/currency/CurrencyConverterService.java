package currency;

public class CurrencyConverterService {

    public double convert(double amount, Currency from, Currency to) {
        if (from == to) {
            return amount;
        }

        double amountInCzk = amount * from.getRateToCzk();

        return amountInCzk / to.getRateToCzk();
    }
}
