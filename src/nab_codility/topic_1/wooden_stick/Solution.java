package nab_codility.topic_1.wooden_stick;

public class Solution {
    public int solution(int A, int B) {
        int possibleMax = (A + B) / 4;
        if (possibleMax == 0) {
            return 0;
        }

        for (int i = possibleMax; i > 0; i--) {
            if (A/i + B/i >= 4) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(10, 21));
        System.out.println(new Solution().solution(13, 11));
        System.out.println(new Solution().solution(2, 1));
        System.out.println(new Solution().solution(1, 8));
        System.out.println(new Solution().solution(4, 1));
        System.out.println(new Solution().solution(9, 3));
    }
}
