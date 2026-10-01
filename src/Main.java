import accounts.*;
import service.*;
import person.AccountOwner;
import person.AccountOwnerFactory;
import transfer.DepositTransferService;
import transfer.TransferTransferService;
import transfer.WithdrawTransferService;

public class Main{
    public static void main(String[] args) {
        TransferTransferService service = new TransferTransferService();
        WithdrawTransferService witdraw = new WithdrawTransferService();
        DepositTransferService deposit = new DepositTransferService();

        AccountOwnerFactory accountOwnerFactory = new AccountOwnerFactory();
        BusinessAccountFactory businessAccountFactory = new BusinessAccountFactory();
        StudentAccountFactory studentAccountFactory = new StudentAccountFactory();

        AccountOwner owner = accountOwnerFactory.createAccountOwner("Matěj", "Bartoš");

        StudentAccount student = studentAccountFactory.createStudentAccount(owner,1000,"Delta");
        BusinessAccount business = businessAccountFactory.createBusinessAccount(owner, 5000);

        // 1) First transfer without any commission
        service.transfer(student, business, 200);
        System.out.println("Po převodu 1: " + student.getBalance() + " / " + business.getBalance());
        // 800.0 / 5200.0

        // 2) Second transfer with a commission
        service.transfer(business, student, 1000);
        System.out.println("Po převodu 2: " + student.getBalance() + " / " + business.getBalance());
        // 1800.0 / 4197.0

    }
}