package service;

import accounts.*;
import person.AccountOwner;
import java.util.ArrayList;
import java.util.List;

public class BankAccountService implements IBankAccountService{

    SavingsAccountFactory savingsAccountFactory = new SavingsAccountFactory();
    CurrentAccountFactory currentAccountFactory = new CurrentAccountFactory();
    StudentAccountFactory studentAccountFactory = new StudentAccountFactory();
    BusinessAccountFactory businessAccountFactory = new BusinessAccountFactory();


    List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount currentAccount = currentAccountFactory.createCurrentAccount(accountOwner, balance);
        this.bankAccounts.add(currentAccount);

        return currentAccount;
    }

    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount savingAccount = savingsAccountFactory.createSavingsAccount(accountOwner, balance);
        this.bankAccounts.add(savingAccount);

        return savingAccount;
    }

    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        BankAccount studentAccount = studentAccountFactory.createStudentAccount(accountOwner, balance, school);
        this.bankAccounts.add(studentAccount);

        return studentAccount;
    }

    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount businessAccount = businessAccountFactory.createBusinessAccount(accountOwner, balance);
        this.bankAccounts.add(businessAccount);

        return businessAccount;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}