package Level2;


import java.util.*;

/**
 * [프로그래머스] 롤케이크 자르기
 */

public class CutRollcake {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        sol.solution(topping);

        int[] topping2 = {1, 2, 3, 1, 4};
        sol.solution(topping2);
    }

    static class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            HashSet<Integer> toppingSet = new HashSet<>();
            HashMap<Integer, Integer> toppingMap = new HashMap<>();
            for(int i : topping) {
                if(toppingMap.containsKey(i)) {
                    toppingMap.put(i, toppingMap.get(i)+1);
                } else {
                    toppingMap.put(i, 1);
                }
            }

            for (int element : topping) {
                toppingSet.add(element);

                if (toppingMap.get(element) > 1) {
                    toppingMap.put(element, toppingMap.get(element) - 1);
                } else {
                    toppingMap.remove(element);
                }

                if (toppingMap.size() == toppingSet.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
