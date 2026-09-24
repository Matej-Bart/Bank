package accounts;

import person.AccountOwner;

public class BusinessAccount extends BankAccount {
    public BusinessAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
    }

    public BusinessAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        super(accountOwner, accountNumber, balance);
    }

    @Override
    public void sub(double amount) {
        double MinusAmount=amount*0.1;

        super.sub(MinusAmount);
        super.sub(amount);
    }
}
