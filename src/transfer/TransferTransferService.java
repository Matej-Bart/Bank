package transfer;

import service.TransferLoggerService;
import service.WithdrawLimitService;
import accounts.BankAccount;
import accounts.BusinessAccount;

public class TransferTransferService {
    private static final double BUSINESS_ACCOUNT_TRANSFER_FEE = 0.003;
    private final TransferLoggerService logger;
    double transferFee;
    public TransferTransferService(TransferLoggerService logger) {
        this.logger = logger;
    }
    private final WithdrawLimitService withdrawLimitService = new WithdrawLimitService();
    public void transfer(BankAccount accWithdraw,BankAccount accDeposit,double amount){
        if (accWithdraw == accDeposit) {
            throw new IllegalArgumentException("Cant have the same accounts.");
        }
        if (accWithdraw == null || accDeposit == null) {
            throw new IllegalArgumentException("Cant have the value of null.");
        }
        if (amount<=0){
            throw new IllegalArgumentException("Value of the transfer must be positive.");
        }

        double newWithdraw = accWithdraw.getBalance() - amount;

        if (accWithdraw instanceof BusinessAccount) {
             transferFee = amount * BUSINESS_ACCOUNT_TRANSFER_FEE;
             newWithdraw-= transferFee;
        }
        if (newWithdraw < withdrawLimitService.getWithdrawLimit(accWithdraw)) {
            throw new IllegalArgumentException("Withdraw limit exceeded.");
        }

        logger.logTransfer(accWithdraw, accDeposit, amount, transferFee);
        accWithdraw.setBalance(newWithdraw);
        accDeposit.setBalance(accDeposit.getBalance() + amount);

    }
}
