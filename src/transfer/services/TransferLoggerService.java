package transfer.services;

import accounts.BankAccount;
import transaction.Transaction;
import transaction.TransactionFactory;
import transaction.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {

    private final List<Transaction> transactions = new ArrayList<>();

    private final TransactionFactory transactionFactory;

    public TransferLoggerService(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

    public void logTransfer(BankAccount from, BankAccount to, double amount, double fee) {
        log(transactionFactory.createTransactionHistory(
                TransactionType.TRANSFER,
                from.getAccountNumber(), to.getAccountNumber(), amount, fee, from.getCurrency()));
    }

    public void logDeposit(BankAccount to, double amount) {
        log(transactionFactory.createTransactionHistory(
                TransactionType.DEPOSIT,
                null, to.getAccountNumber(), amount, 0, to.getCurrency()));
    }

    public void logWithdrawal(BankAccount from, double amount) {
        log(transactionFactory.createTransactionHistory(
                TransactionType.WITHDRAWAL,
                from.getAccountNumber(), null, amount, 0, from.getCurrency()));
    }

    private void log(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    public List<Transaction> getTransactionsForAccount(String accountNumber) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (accountNumber.equals(t.getSourceAccountNumber())
                    || accountNumber.equals(t.getTargetAccountNumber())) {
                result.add(t);
            }
        }
        return result;
    }
}
