package accounts;

import person.AccountOwner;

public class SavingsAccount extends BankAccount implements InterestPoint{
    public SavingsAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
    }

    private static final float INTEREST_RATE=0.05f;

    public SavingsAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        super(accountOwner, accountNumber, balance);
    }

    @Override
    public void calculateInterest(){
        double interest = getBalance() * INTEREST_RATE;
        double newBalance= getBalance()+interest;

        super.setBalance(newBalance);
    }

}
