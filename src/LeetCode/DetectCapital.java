package LeetCode;

/**
 * 2023/01/02
 * [Daily LeetCoding Challenge] 520. Detect Capital
 */

public class DetectCapital {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.detectCapitalUse("USA");
        sol.detectCapitalUse("FlaG");
    }

    static class Solution {
        public boolean detectCapitalUse(String word) {
            if(word.length() == 1) return true;

            boolean answer = false;
            String allCapital = word.toUpperCase();
            String notCapital = word.toLowerCase();
            String onlyFirstCapital = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();

            if(word.equals(allCapital) || word.equals(notCapital) || word.equals(onlyFirstCapital)) {
                answer = true;
            }

            return answer;
        }
    }
}
