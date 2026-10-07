package transfer;

import accounts.BankAccount;
import accounts.StudentAccount;
import service.TransferLoggerService;

public class DepositTransferService {
    private static final double STUDENT_ACCOUNT_DEPOSIT_BONUS = 0.005;
    private final TransferLoggerService logger;
    public DepositTransferService(TransferLoggerService logger) {
        this.logger = logger;
    }

    public void withdraw(BankAccount bankAccount, double amount) {
        double newBalance = bankAccount.getBalance() + amount;

        if (bankAccount instanceof StudentAccount) {
            double depositBonus = amount * STUDENT_ACCOUNT_DEPOSIT_BONUS;

            newBalance += depositBonus;
        }
        logger.logDeposit(bankAccount,amount);
    }

}

