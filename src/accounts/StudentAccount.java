package accounts;

import person.AccountOwner;

public class StudentAccount extends BankAccount {

    private String schoolName;
    public StudentAccount(AccountOwner accountOwner, String accountNumber, String schoolName,String uuid) {
        this(accountOwner, accountNumber, 0,schoolName,uuid);

    }

    public StudentAccount(AccountOwner accountOwner, String accountNumber, double balance,String schoolName,String uuid) {
        super(accountOwner,accountNumber,balance,uuid);
        this.schoolName=schoolName;
    }

    public String getSchoolName(){
        return schoolName;
    }
}
