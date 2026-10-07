package transaction;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionFactory {
    public Transaction createTransactionHistory(TransactionType type, String sourceAccountNumber, String targetAccountNumber, double amount, double fee) {
        String uuid = UUID.randomUUID().toString();
        LocalDateTime timestamp = LocalDateTime.now();

        return new Transaction(type,sourceAccountNumber,targetAccountNumber,amount,fee,uuid,timestamp);
    }
}
