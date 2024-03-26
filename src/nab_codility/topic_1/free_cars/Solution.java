package nab_codility.topic_1.free_cars;

import java.util.Arrays;

public class Solution {
    public int solution(int[] P, int[] S) {
        Arrays.sort(S);

        int sumAllPeople = 0;
        for (int people : P) {
            sumAllPeople += people;
        }

        int numberOfRemainingPeople = sumAllPeople;
        int carNeeded = 0;
        for (int i = S.length - 1; i >= 0; i--) {
            carNeeded ++;
            if (numberOfRemainingPeople > S[i]) {
                numberOfRemainingPeople = numberOfRemainingPeople - S[i];
            } else {
                break;
            }
        }
        return carNeeded;
    }

    public static void main(String[] args) {
//        int[] P = {4,4,2,4};
//        int[] S = {5,5,2,5};

        int[] P = {2,3,4,2};
        int[] S = {2,5,7,2};

//        int[] P = {1, 4, 1};
//        int[] S = {1, 5, 1};
        System.out.println(new Solution().solution(P, S));
    }
}
