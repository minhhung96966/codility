package prefixsum.find_pivot_index;

public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        int[] postfixSum = new int[nums.length];
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            postfixSum[i] = sum;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && postfixSum[i+1] == 0) {
                return i;
            }
            if (i == nums.length - 1 && prefixSum[nums.length - 2] == 0) {
                return i;
            }
            if (i > 0 && i < nums.length - 1) {
                if (prefixSum[i-1] == postfixSum[i+1]) {
                    return i;
                }
            }
        }

        return -1;
    }
}
