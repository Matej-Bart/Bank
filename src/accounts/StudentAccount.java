package accounts;

import person.AccountOwner;

public class StudentAccount extends BankAccount {

    private String schoolName;
    public StudentAccount(AccountOwner accountOwner, String accountNumber, String schoolName) {
        this(accountOwner, accountNumber,0,schoolName);

    }

    public StudentAccount(AccountOwner accountOwner, String accountNumber, double balance,String schoolName) {
        super(accountOwner, accountNumber,balance);
        this.schoolName=schoolName;
    }



    @Override
    protected double getMinimumBalance() {
        return -5000;
    }

    public String getSchoolName(){
        return schoolName;
    }
}
