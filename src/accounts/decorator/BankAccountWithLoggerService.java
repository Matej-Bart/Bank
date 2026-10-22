package accounts.decorator;

import accounts.BankAccount;
import person.AccountOwner;
import service.IBankAccountService;

import java.util.List;

public class BankAccountWithLoggerService implements IBankAccountService {

    private final IBankAccountService wrapped;

    public BankAccountWithLoggerService(IBankAccountService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        System.out.println("Creating current account...");
        BankAccount account = wrapped.createCurrentBankAccount(accountOwner, balance);
        System.out.println("Created current account.");
        return account;
    }

    @Override
    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        System.out.println("Creating savings account...");
        BankAccount account = wrapped.createSavingBankAccount(accountOwner, balance);
        System.out.println("Created savings account.");
        return account;
    }

    @Override
    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        System.out.println("Creating student account...");
        BankAccount account = wrapped.createStudentBankAccount(accountOwner, balance, school);
        System.out.println("Created student account.");
        return account;
    }

    @Override
    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        System.out.println("Creating business account...");
        BankAccount account = wrapped.createBusinessBankAccount(accountOwner, balance);
        System.out.println("Created business account.");
        return account;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return wrapped.getBankAccounts();
    }
}