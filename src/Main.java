import accounts.*;
import person.AccountOwner;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        AccountOwner accountOwner= new AccountOwner("Matej","Bartoš");

        BankAccount currentAccount = new CurrentAccount(accountOwner,"123",452);
        BankAccount studentAccount = new StudentAccount(accountOwner,"123",-4999,"Delta");
        BankAccount businessAccount = new BusinessAccount(accountOwner,"123",323);
        BankAccount savingstAccount = new SavingsAccount(accountOwner,"123",32);

        List<BankAccount> bankAccounts=new ArrayList<>();
        bankAccounts.add(currentAccount);
        bankAccounts.add(studentAccount);

        for(BankAccount account: bankAccounts){
            if(account instanceof StudentAccount){
                StudentAccount studentAct = (StudentAccount) account;
                System.out.println("school:"+studentAct.getSchoolName());
            }
        }
        studentAccount.sub(1);
        System.out.println("blance:"+studentAccount.getBalance());
    }
    private static void printBalance(CurrentAccount bankAccount){
        System.out.println("blance:"+bankAccount.getBalance());
    }
}