package PCCP1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * [PCCP 모의고사 #1] 외톨이 알파벳
 */

public class LonelyAlphabet {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String str = "edeaaabbccd";
        System.out.println(sol.solution(str));

        String str2 = "eeddee";
        System.out.println(sol.solution(str2));

        String str3 = "string";
        System.out.println(sol.solution(str3));

        String str4 = "zbzbz";
        System.out.println(sol.solution(str4));
    }

    static class Solution {
        public String solution(String input_string) {
            StringBuilder answer = new StringBuilder();
            HashMap<Character, Integer> stringMap = new HashMap<>();

            if(input_string.length() < 2) return "N";

            for(int i=0; i<input_string.length()-1; i++) {
                int value = 0;
                if(stringMap.containsKey(input_string.charAt(i))) {
                    value = stringMap.get(input_string.charAt(i));
                }

                if(input_string.charAt(i) != input_string.charAt(i+1) ) {
                    stringMap.put(input_string.charAt(i), value+1);
                }
            }

            char lastChar = input_string.charAt(input_string.length()-1);
            if(stringMap.containsKey(lastChar)) {
                stringMap.put(lastChar, stringMap.get(lastChar)+1);
            } else {
                stringMap.put(lastChar, 1);
            }

            for(Character c : stringMap.keySet()) {
                if(stringMap.get(c) > 1) {
                    answer.append(c);
                }
            }
            if(answer.length() == 0) return "N";

            char[] charArr = answer.toString().toCharArray();
            Arrays.sort(charArr);
            answer = new StringBuilder(new String(charArr));

            return answer.toString();
        }
    }
}