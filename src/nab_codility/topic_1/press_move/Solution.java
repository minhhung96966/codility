package nab_codility.topic_1.press_move;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static int solution(String s) {
        Set<Integer> positions = new HashSet<>();
        int successfulMoves = 0;
        int n = s.length();
        for(int i=0;i<n;i++)
            positions.add(i);

        for (int i = 0; i < n; i++) {
            int currentPosition = i;
            char direction = s.charAt(i);

            int targetPosition = currentPosition;
            if (direction == '<') {
                targetPosition--;
            } else if (direction == '>') {
                targetPosition++;
            } else if (direction == '^') {
                targetPosition -= 1000;
            } else if (direction == 'v') {
                targetPosition += 1000;
            }

            if (positions.contains(targetPosition)) {
                // movement unsuccessful
            } else {
                positions.remove(i);
                successfulMoves++;
                positions.add(targetPosition);
            }
        }

        return successfulMoves;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(solution(s));
    }
}
