import accounts.*;
import person.AccountOwner;
import transfer.TransferTransferService;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        TransferTransferService service = new TransferTransferService();

        AccountOwner owner = new AccountOwner("Matěj","Bartoš");

        StudentAccount student = new StudentAccount(owner, "111111/0100",1000, "Delta");
        BusinessAccount business = new BusinessAccount(owner, "222222/0100", 5000);

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