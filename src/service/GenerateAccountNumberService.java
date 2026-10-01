package service;

import java.util.Random;

public class GenerateAccountNumberService {
    private static final int[] WEIGHTS = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
    private Random random = new Random();

    public String generateAccountNumber() {
        String bankCode = "4567";
        String number;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append(random.nextInt(9) + 1); // první číslice nesmí být 0
            for (int i = 1; i < 10; i++) {
                sb.append(random.nextInt(10));
            }
            number = sb.toString();
        } while (!isValidModulo11(number));

        return number + "/" + bankCode;
    }

    private boolean isValidModulo11(String number) {
        int sum = 0;
        int length = number.length();
        for (int i = 0; i < length; i++) {
            int digit = number.charAt(length - 1 - i) - '0';
            sum += digit * WEIGHTS[i];
        }
        return sum % 11 == 0;
    }
}
