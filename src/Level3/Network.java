package Level3;

import java.util.*;

public class Network {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        sol.solution(3, computers);     //2

        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        sol.solution(3, computers2);    //1

        int[][] computers3 = {{1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 1}, {0, 0, 1, 1}};
        sol.solution(4, computers3);    //1

        int[][] computers4 = {{1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}};
        sol.solution(4, computers4);    //2

        int[][] computers5 = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 1, 0, 1}};
        sol.solution(4, computers5);    //1

        int[][] computers6 = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 1}};
        sol.solution(5, computers6);    //3

        int[][] computers7 = {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}};
        sol.solution(6, computers7);    //1
    }

    static class Solution {
        Map<Integer, Integer> hmp = new HashMap();
        int networkId;

        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            hmp.clear();
            networkId = 0;

            dfs(0, visited, n, computers);

            Vector<Integer> ids = new Vector<>();
            for(int key : hmp.keySet()) {
                if(!ids.contains(hmp.get(key))) {
                    ids.add(hmp.get(key));
                }
                //System.out.print("["+key+","+hmp.get(key)+"] ");
            }
            //System.out.println();
            //System.out.println("hmp.size()="+hmp.size()+", ids.size()="+ids.size() + ", n="+n);

            //answer = networkId 개수 + 연결되어있지 않은 컴퓨터 개수의 합
            if(hmp.size() == n) {
                answer = ids.size();
            } else {
                answer = n - hmp.size() + ids.size();
            }

            System.out.println(answer);
            return answer;
        }

        public void dfs(int idx, boolean[] visited, int n, int[][] computers) {
            if(idx > n - 1) {
                return;
            }

            visited[idx] = true;

            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    if (computers[idx][i] == 1) {
                        //System.out.println("computers[" + idx + "][" + i + "]");

                        //networkId 가 같으면 같은 네트워크
                        //idx가 이미 hmp에 존재하면, i는 idx와 같은 네트워크
                        if (hmp.size() != 0 && hmp.containsKey(idx)) {
                            int value = hmp.get(idx);
                            if(hmp.containsKey(i)) {
                                int preValue = hmp.get(i);
                                for(int key : hmp.keySet()) {
                                    if(hmp.get(key) == preValue) {
                                        hmp.put(key, value);
                                    }
                                }
                            } else {
                                hmp.put(i, value);
                            }
                        } else {
                            hmp.put(idx, networkId);
                            hmp.put(i, networkId);
                            networkId++;
                        }
                    }
                }
            }

            visited[idx] = false;
            dfs(idx+1, visited, n, computers);
        }
    }
}

//다른 풀이
/*
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }
}
*/

