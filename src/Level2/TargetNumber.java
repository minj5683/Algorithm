package Level2;

/**
 * DFS/BFS
 */

public class TargetNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numbers = { 1, 1, 1, 1, 1 };
        System.out.println(sol.solution(numbers, 3));

        int[] numbers2 = { 1, 2, 3, 4, 5 };
        System.out.println(sol.solution(numbers2, 3));
    }

    static class Solution {
        int[] numbers;
        int target;
        int answer;

        public int solution(int[] numbers, int target) {
            answer = 0;

            this.numbers = numbers;
            this.target = target;

            dfs(1, numbers[0]);
            dfs(1, -numbers[0]);

            return answer;
        }

        public void dfs(int idx, int result) {
            if(idx > numbers.length - 1) {
                if (result == target)
                    answer++;
                return;
            }

            dfs(idx + 1, result + numbers[idx]);
            dfs(idx + 1, result - numbers[idx]);
        }
    }
}

//다른 풀이
/*
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
*/
