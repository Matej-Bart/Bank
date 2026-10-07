package service;

import accounts.BankAccount;
import transaction.Transaction;
import transaction.TransactionFactory;
import transaction.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {
    private final List<Transaction> transactions = new ArrayList<>();
    private final TransactionFactory transactionFactory = new TransactionFactory();

    public void logTransfer(BankAccount from, BankAccount to, double amount, double fee) {
        log(transactionFactory.createTransactionHistory(
                TransactionType.TRANSFER,
                from.getAccountNumber(), to.getAccountNumber(), amount, fee));
    }

    public void logDeposit(BankAccount to, double amount) {
        log(transactionFactory.createTransactionHistory(
                TransactionType.DEPOSIT,
                null, to.getAccountNumber(), amount, 0));
    }

    public void logWithdrawal(BankAccount from, double amount) {
        log(transactionFactory.createTransactionHistory(
                TransactionType.WITHDRAWAL,
                from.getAccountNumber(), null, amount, 0));
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