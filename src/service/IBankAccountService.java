package service;

import accounts.*;
import person.AccountOwner;

import java.util.List;

public interface IBankAccountService {
    BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance);
    BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance);
    BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school);
    BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance);
    List<BankAccount> getBankAccounts();
}
