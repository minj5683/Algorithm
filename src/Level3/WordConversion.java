package Level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS/BFS
 */

public class WordConversion {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        sol.solution(begin, target, words);

        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        sol.solution(begin, target, words2);
    }

    static class Solution {
        //int[][] matrix = null;            // 인접 행렬
        ArrayList<Integer>[] list = null;   // 인접 리스트
        int[] visited = null;               // 최단 거리 배열
        int[] from = null;                  // 경로 추적

        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            String[] newWords = new String[words.length + 1];   // begin + words[]
            newWords[0] = begin;
            System.arraycopy(words, 0, newWords, 1, words.length);

            //matrix = createMatrix(newWords);
            list = createList(newWords);
            visited = new int[newWords.length];
            from = new int[newWords.length];

            for (int i = 0; i < newWords.length; i++) { // visited 초기화
                visited[i] = -1;
            }

            bfs();

            int idx = -1;   // newWords[] 에서 target 의 index
            for (int i = 0; i < newWords.length; i++) {
                if (newWords[i].equals(target)) idx = i;
            }
            System.out.println("[target index] " + idx);

            // 방문 할 수 있는 경우 (방문 불가능하면 answer = 0)
            if (idx != -1) {
                System.out.print("[path] ");
                tracing(idx);   // 경로 출력
                System.out.println();

                answer = visited[idx];
            }
            System.out.println("[answer] " + answer);
            System.out.println("----------");

            return answer;
        }

        public void bfs() {
            Queue<Integer> q = new LinkedList<>();
            visited[0] = 0;             // 시작 정점(begin) 의 index 가 0, 시작 정점까지의 최단 거리는 0
            q.add(0);                   // queue 에 시작 정점 삽입

            // queue 가 비었다. -> 시작 정점에 연결된 모든 정점을 방문했다.
            while (!q.isEmpty()) {
                int node = q.poll();    // node = queue 의 맨 앞 정점 삭제 & 리턴

                for (int i = 0; i < list[node].size(); i++) {
                    int next = list[node].get(i);           // next = node 에 연결된 다른 모든 정점

                    if (visited[next] == -1) {              // 만약 next 에 방문하지 않았다면
                        visited[next] = visited[node] + 1;  // 이전 정점까지의 거리 + 1
                        from[next] = node;                  // 이전 정점의 정보 저장 (경로 추적)
                        q.add(next);                        // 다음 정점을 queue 에 삽입
                    }
                }
            }
        }

        // 경로 출력
        public void tracing(int node) {
            if (node == 0) return;
            int next = from[node];
            tracing(next);
            System.out.print(next + " ");
        }

        // 인접 리스트
        public ArrayList<Integer>[] createList(String[] newWords) {
            ArrayList<Integer>[] list = new ArrayList[newWords.length];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < newWords.length; i++) {
                for (int j = 0; j < newWords.length; j++) {
                    if (isConvertible(newWords[i], newWords[j]) == 1) {
                        list[i].add(j);
                    }
                }
            }

            /*for(int i=0; i<list.length; i++) {
                System.out.print(i + " | ");
                for(int j=0; j<list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }*/

            return list;
        }

        // 인접 행렬
        public int[][] createMatrix(String[] newWords) {
            int[][] matrix = new int[newWords.length][newWords.length];

            for (int i = 0; i < newWords.length; i++) {
                for (int j = 0; j < newWords.length; j++) {
                    matrix[i][j] = isConvertible(newWords[i], newWords[j]);
                }
            }

            /*for(int i=0; i<newWords.length; i++) {
                for(int j=0; j<newWords.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }*/

            return matrix;
        }

        // 변환 가능 여부
        public int isConvertible(String word1, String word2) {
            int count = 0;

            if (word1.equals(word2)) return 0;

            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) count++;

                if (count > 1) return 0;
            }
            return 1;
        }

    }
}
