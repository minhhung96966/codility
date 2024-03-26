package prefixsum.product_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int[] prefixProduct = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            prefixProduct[i] = product;
        }


        int[] postfixProduct = new int[nums.length];
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            postfixProduct[i] = product;
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                answer[i] = postfixProduct[i + 1];
            } else if (i == nums.length - 1) {
                answer[i] = prefixProduct[i - 1];
            } else {
                answer[i] = prefixProduct[i - 1] * postfixProduct[i + 1];
            }
        }

        return answer;
    }
}
