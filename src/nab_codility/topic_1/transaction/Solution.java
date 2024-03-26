package nab_codility.topic_1.transaction;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] A, String[] D) {
        int balance = 0;
        Map<Integer, Integer> monthlyFees = new HashMap<>();
        Map<Integer, Integer> monthlyPayments = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            balance += A[i];
            LocalDate date = LocalDate.parse(D[i]);
            int month = date.getMonthValue();
            if (A[i] < 0) {
                monthlyFees.put(month, monthlyFees.getOrDefault(month, 0) + A[i]);
                monthlyPayments.put(month, monthlyPayments.getOrDefault(month, 0) + 1);
            }
        }
        for (int month : monthlyFees.keySet()) {
            if (monthlyFees.get(month) > -100 || monthlyPayments.get(month) < 3) {
                balance -= 5;
            }
        }
        balance -= (12 - monthlyFees.size()) * 5;
        return balance;
    }
}
