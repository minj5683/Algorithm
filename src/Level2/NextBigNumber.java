package Level2;

public class NextBigNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(78));
        System.out.println(sol.solution(15));
    }
}

class Solution {
    public int solution(int n) {
        int answer = n + 1;

        while(getCnt(n) != getCnt(answer)) {
            answer++;
        }
        return answer;
    }

    public int getCnt(int n) {
        int cnt = 0;
        String binStr = Integer.toBinaryString(n);
        for(int i=0; i<binStr.length(); i++) {
            if(binStr.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }

    /**
     * 다른 사람의 풀이
     */
    public int nextBigNumber(int n) {
        int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}