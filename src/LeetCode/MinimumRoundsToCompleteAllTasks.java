package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023/01/04
 * [Daily LeetCoding Challenge] 2244. Minimum Rounds to Complete All Tasks
 */

public class MinimumRoundsToCompleteAllTasks {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumRounds(new int[] {2,2,3,3,2,4,4,4,4,4}));
        System.out.println(sol.minimumRounds(new int[] {2,3,3}));
        System.out.println(sol.minimumRounds(new int[] {2,2,3,3,3,3,3,3,3,3}));
    }

    static class Solution {
        public int minimumRounds(int[] tasks) {
            if(tasks.length == 1) return -1;

            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();

            for(int task : tasks) {
                map.put(task, map.getOrDefault(task, 0) + 1);
            }

            for(int count : map.values()) {
                if(count == 1) {
                    return -1;
                } else if(count % 3 == 0) {
                    answer += count / 3;
                } else {
                    answer += count / 3 + 1;
                }
            }

            /*
            for(int task : tasks) {
                if(map.containsKey(task)) {
                    map.put(task, map.get(task) + 1);
                } else {
                    map.put(task, 1);
                }
            }

            for(int key : map.keySet()) {
                if(map.get(key) == 1) {
                    return -1;
                } else if(map.get(key) % 3 == 0){
                    answer += map.get(key) / 3;
                } else {
                    answer += map.get(key) / 3 + 1;
                }
            }
            */

            return answer;
        }
    }
}
