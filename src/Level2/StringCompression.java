package Level2;

import java.util.Vector;

public class StringCompression {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("aabbaccc" + " -> " + sol.solution("aabbaccc"));
        System.out.println("abcabcabcabcdededededede" + " -> " + sol.solution("abcabcabcabcdededededede"));
    }

    static class Solution {
        public int solution(String s) {
            int answer = s.length();
            int cnt = 0;

            for(int i=1; i<s.length(); i++) {
                cnt = compression(splitString(s, i));
                if(answer > cnt)
                    answer = cnt;
            }

            return answer;
        }

        public Vector<String> splitString(String s, int unit) {
            Vector<String> stringVector = new Vector<>();
            int index = 0;
            for(int i=0; i<s.length(); i+=unit) {
                index = Math.min(i + unit, s.length());
                stringVector.add(s.substring(i, index));
            }
            return stringVector;
        }

        public int compression(Vector<String> v) {
            String str = "";
            int cnt = 1;

            for(int i=0; i<v.size() - 1; i++) {
                if(v.get(i).equals(v.get(i + 1))) {
                    cnt++;
                } else {
                    str += (cnt == 1) ? v.get(i) : cnt + v.get(i);
                    cnt = 1;
                }
            }
            if(v.get(v.size()-2).equals(v.get(v.size()-1))) {
                str += cnt + v.get(v.size()-1);
            } else {
                str += v.get(v.size()-1);
            }

            return str.length();
        }
    }
}

