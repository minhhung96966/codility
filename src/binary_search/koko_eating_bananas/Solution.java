package binary_search.koko_eating_bananas;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int minResult = max;

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = (right + left) / 2;

            System.out.println("\n");
            System.out.println("right: " + right + " left: " + left);
            System.out.println("mid: " + mid);

            long totalHourToEatAllBanana = 0; // using long because test case contains overflow value integer

            for (int pile : piles) {
                int totalHourToEat = ((int) Math.ceil((double) pile/mid));

                System.out.println(totalHourToEat);

                totalHourToEatAllBanana += totalHourToEat;
            }

            System.out.println("totalHourToEatAllBanana: " + totalHourToEatAllBanana);

            if (totalHourToEatAllBanana <= h) { //eat much
                minResult = Math.min(minResult, mid);
                right = mid - 1;
            } else { // eat less
                left = mid + 1;
            }
        }
        return minResult;
    }

    public static void main(String[] args) {
//        int[] a = {312884470};
//        int h = 312884469;

        int[] a = {805306368, 805306368, 805306368};
        int h = 1000000000;
        System.out.println(new Solution().minEatingSpeed(a, h));
    }
}
