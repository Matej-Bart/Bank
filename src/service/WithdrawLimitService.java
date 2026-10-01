package service;

import accounts.BankAccount;
import accounts.StudentAccount;

public class WithdrawLimitService {
    public int getWithdrawLimit(BankAccount account){
        if (account instanceof StudentAccount){
            return -5000;
        }
        return 0;
    }
}
