import accounts.*;
import accounts.decorator.BankAccountWithLoggerService;
import accounts.decorator.BankAccountWithTimeStampLoggerService;
import accounts.serialization.*;
import service.*;
import person.AccountOwner;
import person.AccountOwnerFactory;
import transfer.DepositTransferService;
import transfer.TransferTransferService;
import transfer.WithdrawTransferService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AccountOwnerFactory accountOwnerFactory = new AccountOwnerFactory();

        TransferLoggerService logger = new TransferLoggerService();

        TransferTransferService service = new TransferTransferService(logger);
        WithdrawTransferService witdraw = new WithdrawTransferService(logger);
        DepositTransferService deposit = new DepositTransferService(logger);

        AccountOwner owner = accountOwnerFactory.createAccountOwner("Matěj", "Bartoš");

        BankAccountService bankAccountService = new BankAccountService();

        IBankAccountService loggerService = new BankAccountWithLoggerService(bankAccountService);
        IBankAccountService timeLoggerService = new BankAccountWithTimeStampLoggerService(bankAccountService);
        IBankAccountService combinedService = new BankAccountWithLoggerService(
                new BankAccountWithTimeStampLoggerService(new BankAccountService()));

        BankAccount student = loggerService.createStudentBankAccount(owner, 1000, "Delta");
        BankAccount business = timeLoggerService.createBusinessBankAccount(owner, 5000);
        BankAccount student2 = combinedService.createStudentBankAccount(owner, 1000, "Delta");

        BankAccountJacksonXmlSerializer bankAccountXmlSerializator = new BankAccountJacksonXmlSerializer();
        String bankAccountXml = bankAccountXmlSerializator.serialize(student);
        System.out.println(bankAccountXml);

        BankAccountGsonSerializer bankAccountJsonSerializator = new BankAccountGsonSerializer();
        String bankAccountJson = bankAccountJsonSerializator.serialize(student);
        System.out.println(bankAccountJson);

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(student);
        accounts.add(business);

        BankAccountSerializer xmlSerializer = new BankAccountXmlSerializer();
        System.out.println(xmlSerializer.serializeAll(accounts));

        BankAccountSerializer jsonSerializer = new BankAccountGsonSerializer();
        System.out.println(jsonSerializer.serializeAll(accounts));

        // 1) First transfer without any commission
        service.transfer(student, business, 200);
        System.out.println("Po převodu 1: " + student.getBalance() + " / " + business.getBalance());
        // 800.0 / 5200.0

        // 2) Second transfer with a commission
        service.transfer(business, student, 1000);
        System.out.println("Po převodu 2: " + student.getBalance() + " / " + business.getBalance());
        // 1800.0 / 4197.0
        deposit.deposit(student, 500);
        witdraw.withdraw(student, 100);
        System.out.println(student.getBalance());
        System.out.println(logger.getAllTransactions());
    }
}