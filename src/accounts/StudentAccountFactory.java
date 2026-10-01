package accounts;

import service.GenerateAccountNumberService;
import person.AccountOwner;

import java.util.UUID;

public class StudentAccountFactory {
    private final GenerateAccountNumberService Gen = new GenerateAccountNumberService();
    public StudentAccount createStudentAccount(AccountOwner accountOwner,String schoolName){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new StudentAccount(accountOwner,accountNumber,schoolName,uuid);
    }
    public StudentAccount createStudentAccount(AccountOwner accountOwner, double balance,String schoolName){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new StudentAccount(accountOwner, accountNumber,balance,schoolName,uuid);
    }
}
