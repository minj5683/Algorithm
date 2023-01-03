package LeetCode;

/**
 * 2023/01/03
 * [Daily LeetCoding Challenge] 944. Delete Columns to Make Sorted
 */

public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minDeletionSize(new String[]{"cba", "daf", "ghi"});
        sol.minDeletionSize(new String[]{"a", "b"});
        sol.minDeletionSize(new String[]{"zyx", "wvu", "tsr"});
        sol.minDeletionSize(new String[]{"rrjk", "furt", "guzm"});
    }

    static class Solution {
        public int minDeletionSize(String[] strs) {
            int answer = 0;
            int strLen = strs[0].length();

            for(int i=0; i<strLen; i++) {
                for(int j=1; j<strs.length; j++) {
                    if(strs[j].charAt(i) < strs[j-1].charAt(i)) {
                        answer++;
                        break;
                    }
                }
            }

            return answer;


            /*
            int strLen = strs[0].length();
            Map<Integer, Character> map = new HashMap<>();

            for (int i = 0; i < strLen; i++) {
                map.put(i, strs[0].charAt(i));
            }

            for (int i = 1; i < strs.length; i++) {
                for (int j = 0; j < strLen; j++) {
                    if (map.containsKey(j)) {
                        if (map.get(j) <= strs[i].charAt(j)) {
                            map.put(j, strs[i].charAt(j));
                        } else {
                            map.remove(j);
                        }
                    }
                }
            }

            System.out.println(strLen - map.size());
            return strLen - map.size();
            */
        }
    }
}
