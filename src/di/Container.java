package di;

import accounts.factories.BankAccountFactory;
import accounts.serialization.BankAccountGsonSerializer;
import accounts.serialization.BankAccountSerializeFactory;
import accounts.serialization.BankAccountSerializer;
import accounts.serialization.BankAccountXmlSerializer;
import accounts.services.AccountNumberGenerator;
import accounts.services.BankAccountService;
import accounts.services.IBankAccountService;
import accounts.services.decorators.BankAccountWithLoggerService;
import accounts.services.decorators.BankAccountWithLoggerWithTimeService;
import currency.Currency;
import currency.CurrencyConverterService;
import currency.MoneyFormatterService;
import person.factories.AccountOwnerFactory;
import person.services.AccountOwnerService;
import transaction.TransactionFactory;
import transfer.DepositTransferService;
import transfer.TransferTransferService;
import transfer.WithdrawTransferService;
import transfer.services.TransferLoggerService;
import transfer.services.WithdrawLimitService;

public class Container {

    public AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator("0800");

    AccountOwnerFactory accountOwnerFactory = new AccountOwnerFactory();
    public AccountOwnerService accountOwnerService
            = new AccountOwnerService(accountOwnerFactory);

    public BankAccountFactory bankAccountFactory = new BankAccountFactory(accountNumberGenerator);

    public IBankAccountService bankAccountService
            = new BankAccountService(bankAccountFactory);
    public IBankAccountService bankAccountWithLoggerService
            = new BankAccountWithLoggerService(bankAccountService);
    public IBankAccountService bankAccountWithTimeLoggerService
            = new BankAccountWithLoggerWithTimeService(bankAccountService);
    public IBankAccountService bankAccountWithLoggerAndTimeLoggerService
            = new BankAccountWithLoggerService(bankAccountWithTimeLoggerService);

    public BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    public BankAccountSerializer bankAccountJsonSerializer = new BankAccountGsonSerializer(bankAccountSerializeFactory);
    public BankAccountSerializer bankAccountXmlSerializer = new BankAccountXmlSerializer(bankAccountSerializeFactory);

    public CurrencyConverterService currencyConverterService = new CurrencyConverterService();
    public MoneyFormatterService moneyFormatterService
            = new MoneyFormatterService(currencyConverterService, Currency.EUR);

    public TransactionFactory transactionFactory = new TransactionFactory();
    public TransferLoggerService transferLoggerService = new TransferLoggerService(transactionFactory);
    public WithdrawLimitService withdrawLimitService = new WithdrawLimitService();

    public DepositTransferService depositTransferService
            = new DepositTransferService(transferLoggerService);
    public WithdrawTransferService withdrawTransferService
            = new WithdrawTransferService(transferLoggerService, withdrawLimitService);
    public TransferTransferService transferTransferService
            = new TransferTransferService(transferLoggerService, withdrawLimitService, currencyConverterService);

}
