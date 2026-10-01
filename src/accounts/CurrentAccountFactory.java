package accounts;

import service.GenerateAccountNumberService;
import person.AccountOwner;

import java.util.UUID;

public class CurrentAccountFactory {
    private final GenerateAccountNumberService Gen = new GenerateAccountNumberService();
    public CurrentAccount createCurrentAccount(AccountOwner accountOwner){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new CurrentAccount(accountOwner,accountNumber,uuid);
    }
    public CurrentAccount createCurrentAccount(AccountOwner accountOwner, double balance){
        String uuid = UUID.randomUUID().toString();
        String accountNumber=Gen.generateAccountNumber();

        return new CurrentAccount(accountOwner, accountNumber, balance,uuid);
    }
}
