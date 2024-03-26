package hashing.valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> firstHashMap = new HashMap<>();
        Map<Character, Integer> secondHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (firstHashMap.containsKey(s.charAt(i))) {
                int currentValue = firstHashMap.get(s.charAt(i));
                firstHashMap.put(s.charAt(i), currentValue + 1);
            } else {
                firstHashMap.put(s.charAt(i), 1);
            }

            if (secondHashMap.containsKey(t.charAt(i))) {
                int currentValue = secondHashMap.get(t.charAt(i));
                secondHashMap.put(t.charAt(i), currentValue + 1);
            } else {
                secondHashMap.put(t.charAt(i), 1);
            }
        }

        return firstHashMap.equals(secondHashMap);
    }
}
