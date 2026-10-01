package accounts;

import service.GenerateAccountNumberService;
import person.AccountOwner;

import java.util.UUID;

public class BusinessAccountFactory {
    private final GenerateAccountNumberService Gen = new GenerateAccountNumberService();
    public BusinessAccount createBusinessAccount(AccountOwner accountOwner){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new BusinessAccount(accountOwner,accountNumber,uuid);
    }
    public BusinessAccount createBusinessAccount(AccountOwner accountOwner, double balance){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new BusinessAccount(accountOwner, accountNumber, balance,uuid);
    }
}
