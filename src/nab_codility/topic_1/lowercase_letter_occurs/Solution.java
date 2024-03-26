package nab_codility.topic_1.lowercase_letter_occurs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Write a function solution that, given an integer N, returns a string of length N containing as many different lower-case letters ('a'-'z') as possible, in which each letter occurs an equal number of times.

Examples:

1. Given N = 3, the function may return "fig", "pea", "nut", etc. Each of these

strings contains three different letters with the same number of occurrences

2 Given N = 5, the function may return "mango", "grape", "melon", etc.


3. Given N = 30, the function may return "aabbcc. oo" (each letter from 'a' to 'o' occurs twice). The string contains 15 different letters

Write an efficient algorithm for the following assumptions:

⚫N is an integer within the range [1. 200,000]
* */

public class Solution {

    // Function to generate a string with equal occurrences of lowercase letters
    public static String solution(int N) {
        // Check if N is within the valid range
        if (N < 1 || N > 200000) {
            throw new IllegalArgumentException("N should be in the range [1, 200,000]");
        }

        // Create a list of lowercase letters
        List<Character> letters = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            letters.add(ch);
        }

        // Calculate the number of times each letter should occur
        int occurrences = N / 26;
        int remainder = N % 26;

        // Shuffle the letters to get a random order
        Collections.shuffle(letters);

        // Build the string with equal occurrences of letters
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < occurrences; i++) {
            // Add each letter to the result string occurrences times
            for (char letter : letters) {
                result.append(letter);
            }
        }

        // Add the remaining letters to fulfill the length N
        for (int i = 0; i < remainder; i++) {
            result.append(letters.get(i));
        }

        // Return the final string
        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        int N = 70;
        //int N = 3;

        // Call the solution function and print the result
        String result = solution(N);
        System.out.println(result);
    }
}
