package stack.valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        System.out.println("\n");

        Stack<String> stack = new Stack<>();
        Map<String, String> closeToOpen = new HashMap<>();
        closeToOpen.put(")", "(");
        closeToOpen.put("]", "[");
        closeToOpen.put("}", "{");

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));

            if (closeToOpen.containsKey(String.valueOf(s.charAt(i)))) {
                System.out.println(s.charAt(i) + " is close parentheses so that should be in hashmap, we will compare to latest value of stack");
                if (!stack.empty()
                        && stack.peek().equals(closeToOpen.get(String.valueOf(s.charAt(i))))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                System.out.println(s.charAt(i) + " is open parentheses so that not in hashmap, we will push to stack");
                stack.push(String.valueOf(s.charAt(i)));
                System.out.println(stack);
            }

            System.out.println("\n");
        }

        return stack.empty();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isValid("()"));
//        System.out.println(new Solution().isValid("()[]{}"));
//        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("{[]}"));
    }
}
