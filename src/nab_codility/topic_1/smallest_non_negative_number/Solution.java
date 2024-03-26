package nab_codility.topic_1.smallest_non_negative_number;

/**
 *
 * write a function solution that , given integer N, returns the smallest non negative integer whose individual digits sum to N.
 *
 * Given N = 16, the function should return 79, there are many numbers whose digits sum to 16 (for example : 79, 97,808,551,22822,etc.) . the smallest such number is 79.
 *
 * 2. given N = 19, THE FUNCTION SHOULD RETURN 199 (the sum of digits is 1+9+9 = 19).
 *
 * 3. Given N= 7, the function should return 7.
 *
 * asume that:
 *
 * N is an interger within the range [0..50].
 *
 *
 *
 * */
public class Solution {
    public int smallestNumber(int N) {
        if (N == 0) {
            return 0;
        }
        if (N < 10) {
            return N;
        }
        int[] result = new int[50];
        int m = 0;
        for (int i=9; i>0 && N>0; i--) {
            while (N >= i) {
                N -= i;
                result[m] = i;
                m++;
            }
        }
        if (N > 0) {
            return -1;
        }
        int num = 0;
        for (int i=m-1; i>=0; i--) {
            num = num * 10 + result[i];
        }
        return num;
    }

    public int smallestNumberV2(int N) {
        int temp1; int count=1; int temp2; //declarations
        while(true) //outer while loop
        {
            temp1=count;
            temp2=0;
            while(temp1>0) //inner loop
            {
                temp2=temp2+(temp1%10);   //temp 2 = 79%10 = 9      temp 1 = 79/10 = 7   temp2 = 9 + 7 = 16   temp 1 = 7 / 10 = 0
                temp1=temp1/10;
            }
            if(N==temp2)
                break; //breaks the outer while loop
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber(45));
    }
}
