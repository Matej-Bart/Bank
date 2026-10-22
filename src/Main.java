import accounts.*;
import accounts.serialization.*;
import service.*;
import person.AccountOwner;
import person.AccountOwnerFactory;
import transfer.DepositTransferService;
import transfer.TransferTransferService;
import transfer.WithdrawTransferService;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        AccountOwnerFactory accountOwnerFactory = new AccountOwnerFactory();
        BusinessAccountFactory businessAccountFactory = new BusinessAccountFactory();
        StudentAccountFactory studentAccountFactory = new StudentAccountFactory();

        TransferLoggerService logger = new TransferLoggerService();

        TransferTransferService service = new TransferTransferService(logger);
        WithdrawTransferService witdraw = new WithdrawTransferService(logger);
        DepositTransferService deposit = new DepositTransferService(logger);

        AccountOwner owner = accountOwnerFactory.createAccountOwner("Matěj", "Bartoš");

        AccountLoggerService accountLogger = new AccountLoggerService();
        LoggingAccountFactory accountFactory = new LoggingAccountFactory(accountLogger);

        StudentAccount student = accountFactory.createStudentAccount(owner, 1000, "Delta");
        BusinessAccount business = accountFactory.createBusinessAccount(owner, 5000);

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
        deposit.deposit(student,500);
        witdraw.withdraw(student,100);
        System.out.println(student.getBalance());
        System.out.println(logger.getAllTransactions());
    }
}