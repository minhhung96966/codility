package nab_codility.topic_1.char_in_format;

public class Solution {
    public int solution(String S) {
        int n = S.length(); // length of input string
        int countA = 0; // count number of 'A's in string

        for (char c : S.toCharArray()) {
            if (c == 'A') {
                countA++;
            }
        }
        int countB = n - countA; // count number of 'B's in string
        int result = n; // initialize result to maximum possible value (deleting all characters)
        int currentA = 0; // initialize current count of 'A's seen so far
        int currentB = 0; // initialize current count of 'B's seen so far

        for (int i = 0; i < S.length() + 1; i++) {
            result = Math.min(result, currentB + (countA - currentA)); // update minimum deletions
            if (i < n) {
                if (S.charAt(i) == 'A') {
                    currentA += 1; // update current count of 'A's seen so far
                } else {
                    currentB += 1; // update current count of 'B's seen so far
                }
            }
        }

        return result; // return minimum deletions required
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
//        System.out.println(solution.solution("BAAABAB"));  // Output: 2
//        System.out.println(solution.solution("BBABAA"));   // Output: 3
//        System.out.println(solution.solution("AABBBB"));   // Output: 0
        System.out.println(solution.solution("AABBBBA"));   // Output: 1
    }
}
