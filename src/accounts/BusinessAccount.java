package accounts;

import person.AccountOwner;

public class BusinessAccount extends BankAccount {
    public BusinessAccount(AccountOwner accountOwner, String accountNumber,String uuid) {
        super(uuid,accountOwner, accountNumber);
    }

    public BusinessAccount(AccountOwner accountOwner, String accountNumber, double balance,String uuid) {
        super(accountOwner, accountNumber, balance,uuid);
    }
}
