package PCCP1;

/**
 * [PCCP 모의고사 #1] 체육대회
 */

public class AthleticCompetition {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        sol.solution(ability);

        int[][] ability2 = {{20, 30}, {30, 20}, {20, 30}};
        sol.solution(ability2);
    }

    static class Solution {
        int answer;

        public int solution(int[][] ability) {
            answer = 0;
            int n = ability.length;     // 학생 수
            int r = ability[0].length;  // 종목 수
            int[] output = new int[n];
            boolean[] visited = new boolean[n];

            // 전체 학생 수에서 종목 수만큼 순서 있게 뽑기 -> 순열
            perm(ability, output, visited, 0, r);

            System.out.println(answer);
            return answer;
        }

        public void perm(int[][] arr, int[] output, boolean[] visited, int depth, int r) {
            if (depth == r) {
                if(answer < sum(output, r)) {
                    answer = sum(output, r);
                }
                return;
            }

            for (int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = arr[i][depth];
                    perm(arr, output, visited, depth + 1, r);
                    visited[i] = false;
                }
            }
        }

        public int sum(int[] arr, int r) {
            int sum = 0;
            for (int i=0; i<r; i++)
                sum += arr[i];
            return sum;
        }
    }
}