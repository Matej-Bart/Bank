package accounts.decorator;

import accounts.BankAccount;
import person.AccountOwner;
import service.IBankAccountService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankAccountWithTimeStampLoggerService implements IBankAccountService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

    private final IBankAccountService wrapped;

    public BankAccountWithTimeStampLoggerService(IBankAccountService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        System.out.println("Creating current account... [" + now() + "]");
        BankAccount account = wrapped.createCurrentBankAccount(accountOwner, balance);
        System.out.println("Created current account. [" + now() + "]");
        return account;
    }

    @Override
    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        System.out.println("Creating savings account... [" + now() + "]");
        BankAccount account = wrapped.createSavingBankAccount(accountOwner, balance);
        System.out.println("Created savings account. [" + now() + "]");
        return account;
    }

    @Override
    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        System.out.println("Creating student account... [" + now() + "]");
        BankAccount account = wrapped.createStudentBankAccount(accountOwner, balance, school);
        System.out.println("Created student account. [" + now() + "]");
        return account;
    }

    @Override
    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        System.out.println("Creating business account... [" + now() + "]");
        BankAccount account = wrapped.createBusinessBankAccount(accountOwner, balance);
        System.out.println("Created business account. [" + now() + "]");
        return account;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return wrapped.getBankAccounts();
    }

    private String now() {
        return LocalDateTime.now().format(FORMATTER);
    }
}