package currency;

import java.util.Locale;

public class MoneyFormatterService {

    private final CurrencyConverterService currencyConverterService;
    private final Currency conversionCurrency;

    public MoneyFormatterService(CurrencyConverterService currencyConverterService,
                                 Currency conversionCurrency) {
        this.currencyConverterService = currencyConverterService;
        this.conversionCurrency = conversionCurrency;
    }

    // např. "500.00 CZK (20.58 EUR)"
    public String format(double amount, Currency currency) {
        Currency target = conversionCurrency;
        if (currency == conversionCurrency) {
            target = Currency.CZK; // účet už je v převodní měně, ukážeme CZK
        }

        double converted = currencyConverterService.convert(amount, currency, target);

        return String.format(Locale.ROOT, "%.2f %s (%.2f %s)", amount, currency, converted, target);
    }
}
