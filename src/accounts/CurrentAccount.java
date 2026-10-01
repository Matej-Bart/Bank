package accounts;

import person.AccountOwner;

public class CurrentAccount extends BankAccount{

    public CurrentAccount(AccountOwner accountOwner, String accountNumber,String uuid) {
        super(uuid,accountOwner, accountNumber);
    }

    public CurrentAccount(AccountOwner accountOwner, String accountNumber, double balance,String uuid) {
        super(accountOwner, accountNumber, balance,uuid);
    }
}
