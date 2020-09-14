package Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class OpenChatRoom {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };

        System.out.println(Arrays.toString(sol.solution(record)));
    }

    static class Solution {
        String[] record;
        HashMap<String, String> userMap = new HashMap<>();              //user id, nickname
        HashMap<String, Vector<String>> recordMap = new HashMap<>();    //user id, record string vector
        String uid = "";
        String keyword = "";
        int answerSize = 0;

        public String[] solution(String[] record) {
            this.record = record;

            initUserMap();
            initRecordMap();

            setRecordMap();
            setUserMap();

            int index = 0;
            String resultStr = "";
            String[] answer = new String[answerSize];
            for (String s : record) {
                uid = s.split(" ")[1];
                keyword = s.split(" ")[0];

                resultStr = userMap.get(uid) + "님이 ";

                if (keyword.equals("Enter")) {
                    resultStr += "들어왔습니다.";
                    answer[index++] = resultStr;
                } else if (keyword.equals("Leave")) {
                    resultStr += "나갔습니다.";
                    answer[index++] = resultStr;
                }
            }

            return answer;
        }

        public void initUserMap() {
            for (String s : record) {
                uid = s.split(" ")[1];
                userMap.put(uid, "");
            }
        }

        public void initRecordMap() {
            for (String key : userMap.keySet()) {
                recordMap.put(key, new Vector<String>());
            }
        }

        public void setRecordMap() {
            Vector<String> temp;
            for (String s : record) {
                uid = s.split(" ")[1];
                temp = recordMap.get(uid);
                temp.add(s);
                recordMap.put(uid, temp);
            }
        }

        public void setUserMap() {
            String nickName = "";
            for (String key : recordMap.keySet()) {
                Vector<String> userRecord = recordMap.get(key);

                nickName = "";
                for (String s : userRecord) {
                    keyword = s.split(" ")[0];

                    if ((keyword.equals("Enter") && !nickName.equals(s.split(" ")[2])) || keyword.equals("Change")) {
                        nickName = s.split(" ")[2];
                    }

                    if (!keyword.equals("Change")) answerSize++;
                }
                userMap.put(key, nickName);
            }
        }

    }
}
