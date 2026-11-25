package transfer;

import accounts.BankAccount;
import accounts.BusinessAccount;
import currency.CurrencyConverterService;
import transfer.services.TransferLoggerService;
import transfer.services.WithdrawLimitService;

public class TransferTransferService {

    private static final double BUSINESS_ACCOUNT_TRANSFER_FEE = 0.003;

    private final TransferLoggerService transferLoggerService;
    private final WithdrawLimitService withdrawLimitService;
    private final CurrencyConverterService currencyConverterService;

    public TransferTransferService(TransferLoggerService transferLoggerService,
                                   WithdrawLimitService withdrawLimitService,
                                   CurrencyConverterService currencyConverterService) {
        this.transferLoggerService = transferLoggerService;
        this.withdrawLimitService = withdrawLimitService;
        this.currencyConverterService = currencyConverterService;
    }

    public void transfer(BankAccount accWithdraw, BankAccount accDeposit, double amount) {
        if (accWithdraw == null || accDeposit == null) {
            throw new IllegalArgumentException("Cant have the value of null.");
        }
        if (accWithdraw == accDeposit) {
            throw new IllegalArgumentException("Cant have the same accounts.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Value of the transfer must be positive.");
        }

        double transferFee = 0;
        if (accWithdraw instanceof BusinessAccount) {
            transferFee = amount * BUSINESS_ACCOUNT_TRANSFER_FEE;
        }

        double newWithdraw = accWithdraw.getBalance() - amount - transferFee;

        if (newWithdraw < withdrawLimitService.getWithdrawLimit(accWithdraw)) {
            throw new IllegalArgumentException("Withdraw limit exceeded.");
        }

        double depositAmount = currencyConverterService.convert(
                amount, accWithdraw.getCurrency(), accDeposit.getCurrency());

        accWithdraw.setBalance(newWithdraw);
        accDeposit.setBalance(accDeposit.getBalance() + depositAmount);

        transferLoggerService.logTransfer(accWithdraw, accDeposit, amount, transferFee);
    }
}
