package Level2;

/**
 * [프로그래머스] 점 찍기
 * 원의 방정식 
 */

public class Dot {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.solution(2, 4);
        sol.solution(1, 5);
        sol.solution(2, 1000000);
    }


    static class Solution {
        public long solution(int k, int d) {
            long answer = 0;

            for(int x=0; x<=d; x+=k) {
                int y = equation(x, d);
                answer += y / k + 1;
            }

            System.out.println(answer);
            return answer;
        }

        public int equation(long x, long d) {
            return (int) Math.sqrt(d*d - x*x);
        }
    }
}
