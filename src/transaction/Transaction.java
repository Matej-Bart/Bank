package transaction;

import java.time.LocalDateTime;

public class Transaction {
    private final String uuid;
    private final TransactionType type;
    private final String sourceAccountNumber;
    private final String targetAccountNumber;
    private final double amount;
    private final double fee;
    private final LocalDateTime timestamp;
    public Transaction(TransactionType type, String sourceAccountNumber, String targetAccountNumber, double amount, double fee, String uuid, LocalDateTime time) {
        this.uuid = uuid;
        this.type = type;
        this.sourceAccountNumber = sourceAccountNumber;
        this.targetAccountNumber = targetAccountNumber;
        this.amount = amount;
        this.fee = fee;
        this.timestamp = time;
    }
    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }
    @Override//at vypis je citelny
    public String toString() {
        return type + " | z: " + sourceAccountNumber + " | na: " + targetAccountNumber
                + " | částka: " + amount + " | poplatek: " + fee + " | " + timestamp;
    }

}
