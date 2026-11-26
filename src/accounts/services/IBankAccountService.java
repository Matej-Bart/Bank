package accounts.services;

import accounts.BankAccount;
import person.AccountOwner;

import java.util.List;

public interface IBankAccountService {

    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance);

    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance);

    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school);

    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance);

    public List<BankAccount> getBankAccounts();
}
