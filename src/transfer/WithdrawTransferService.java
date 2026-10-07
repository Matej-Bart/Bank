package transfer;

import service.TransferLoggerService;
import service.WithdrawLimitService;
import accounts.BankAccount;
import accounts.BusinessAccount;

public class WithdrawTransferService {


    private static final double BUSINESS_ACCOUNT_SERVICE_FEE =0.01 ;
    private final WithdrawLimitService withdrawLimitService = new WithdrawLimitService();
    private final TransferLoggerService logger;
    public WithdrawTransferService(TransferLoggerService logger) {
        this.logger = logger;
    }

    public void withdraw(BankAccount account, double amount){
        double newBalance = account.getBalance() - amount;

        if (account instanceof BusinessAccount){
            double serviceFee = amount * BUSINESS_ACCOUNT_SERVICE_FEE;

            newBalance -= serviceFee;
        }

        if (newBalance < withdrawLimitService.getWithdrawLimit(account)) {
            throw new IllegalArgumentException("Withdraw limit exceeded.");
        }

        account.setBalance(newBalance);
        logger.logWithdrawal(account, amount);
    }

}
