package transfer;

import accounts.BankAccount;
import accounts.BusinessAccount;
import transfer.services.TransferLoggerService;
import transfer.services.WithdrawLimitService;

public class WithdrawTransferService {

    private static final double BUSINESS_ACCOUNT_SERVICE_FEE = 0.01;

    private final TransferLoggerService transferLoggerService;
    private final WithdrawLimitService withdrawLimitService;

    public WithdrawTransferService(TransferLoggerService transferLoggerService,
                                   WithdrawLimitService withdrawLimitService) {
        this.transferLoggerService = transferLoggerService;
        this.withdrawLimitService = withdrawLimitService;
    }

    public void withdraw(BankAccount account, double amount) {
        double newBalance = account.getBalance() - amount;

        if (account instanceof BusinessAccount) {
            double serviceFee = amount * BUSINESS_ACCOUNT_SERVICE_FEE;

            newBalance -= serviceFee;
        }

        if (newBalance < withdrawLimitService.getWithdrawLimit(account)) {
            throw new IllegalArgumentException("Withdraw limit exceeded.");
        }

        account.setBalance(newBalance);
        transferLoggerService.logWithdrawal(account, amount);
    }

}
