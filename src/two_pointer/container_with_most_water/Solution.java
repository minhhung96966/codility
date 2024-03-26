package two_pointer.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right])*(right - left);
            maxArea = Math.max(area, maxArea);

            if (height[left] > height[right]) {
                right --;
            } else {
                left ++;
            }
        }

        return maxArea;
    }
}
