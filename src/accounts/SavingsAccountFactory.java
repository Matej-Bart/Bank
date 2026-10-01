package accounts;

import service.GenerateAccountNumberService;
import person.AccountOwner;

import java.util.UUID;

public class SavingsAccountFactory {
    private final GenerateAccountNumberService Gen = new GenerateAccountNumberService();
    public SavingsAccount createSavingsAccount(AccountOwner accountOwner){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new SavingsAccount(accountOwner,accountNumber,uuid);
    }
    public SavingsAccount createSavingsAccount(AccountOwner accountOwner, double balance){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new SavingsAccount(accountOwner, accountNumber, balance,uuid);
    }
}
