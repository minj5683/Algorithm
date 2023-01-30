package LeetCode;

/**
 * 2023/01/30
 * [Daily LeetCoding Challenge] 1137. N-th Tribonacci Number
 */

public class NthTribonacciNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.tribonacci(4);
        sol.tribonacci(25);
    }

    static class Solution {
        int answer;

        public int tribonacci(int n) {
            if(n == 0) return 0;
            if(n < 3) return 1;

            answer = 0;
            getTribonacci(n, 3, 0, 1, 1);

            System.out.println(answer);
            return answer;
        }

        public void getTribonacci(int input, int count, int n1, int n2, int n3) {
            if(count == input) {
                this.answer = n1 + n2 + n3;
                return;
            }

            getTribonacci(input, count+1, n2, n3, n1 + n2 + n3);
        }
    }
}
