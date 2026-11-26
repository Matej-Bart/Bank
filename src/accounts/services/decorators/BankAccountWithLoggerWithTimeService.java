package accounts.services.decorators;

import accounts.BankAccount;
import accounts.services.IBankAccountService;
import person.AccountOwner;

import java.time.LocalTime;
import java.util.List;

public class BankAccountWithLoggerWithTimeService implements IBankAccountService {

    IBankAccountService bankAccountService;

    public BankAccountWithLoggerWithTimeService(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        this.logStart();
        BankAccount bankAccount = this.bankAccountService.createCurrentBankAccount(accountOwner, balance);
        this.logEnd();

        return bankAccount;
    }

    @Override
    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        this.logStart();
        BankAccount bankAccount = this.bankAccountService.createSavingBankAccount(accountOwner, balance);
        this.logEnd();

        return bankAccount;
    }

    @Override
    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        this.logStart();
        BankAccount bankAccount = this.bankAccountService.createStudentBankAccount(accountOwner, balance, school);
        this.logEnd();

        return bankAccount;
    }

    @Override
    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        this.logStart();
        BankAccount bankAccount = this.bankAccountService.createBusinessBankAccount(accountOwner, balance);
        this.logEnd();

        return bankAccount;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return this.bankAccountService.getBankAccounts();
    }

    private void logStart() {
        System.out.println("Create Bank Account started, " + LocalTime.now());
    }

    private void logEnd() {
        System.out.println("Create Bank Account finished, " + LocalTime.now());
    }
}
