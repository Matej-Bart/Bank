package transfer;

import accounts.BankAccount;
import accounts.BusinessAccount;

public class TransferTransferService {
    private static final double BUSINESS_ACCOUNT_TRANSFER_FEE = 0.003;
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
            double transferFee = amount * BUSINESS_ACCOUNT_TRANSFER_FEE;
             newWithdraw-= transferFee;
        }

        accWithdraw.setBalance(newWithdraw);
        accDeposit.setBalance(accDeposit.getBalance() + amount);
    }
}
