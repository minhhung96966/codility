package nab_codility.topic_1.castle;

public class Solution {
    public static void main(String[] args) {
        int[] A = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        int result = solution(A);
        System.out.println(result);
    }

    public static int solution(int[] A) {
        int count = 0;
        int N = A.length;
        int index = 0;

        while (index < N) {
            int start = index;

            while (index + 1 < N && A[index] == A[index + 1]) {
                index++;
            }

            if ((start == 0 && (A[index] < A[index + 1] || A[index] > A[index] + 1))
                    || (index == N - 1 && (A[start - 1] < A[start] || A[start - 1] > A[start]))
                    || ((start > 0 && index < N - 1) && ((A[start - 1] < A[start] && A[index] > A[index + 1]) || (A[start - 1] > A[start] && A[index] < A[index + 1])))) {
                count++;
            }

            index++;
        }

        return count;
    }
    //start - index la diem dau va diem cuoi cua nhung doan bang nhau lien tiep, neu k co thi start = index
}
