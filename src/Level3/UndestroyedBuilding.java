package Level3;

/**
 * [2022 KAKAO BLIND RECRUITMENT] 파괴되지 않은 건물
 * 누적합
 */

public class UndestroyedBuilding {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] board1 = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill1 = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        sol.solution(board1, skill1);

        int[][] board2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill2 = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        sol.solution(board2, skill2);
    }

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int[][] sum = new int[board.length+1][board[0].length+1];

            for(int[] i : skill) {
                useSkill(sum, i);
            }
            cumulativeSum(sum);

            return calculateBoard(board, sum);
        }

        public void useSkill(int[][] sum, int[] skill) {
            int type = (skill[0] == 1) ? -1 : 1;    // 적군이면 -1, 아군이면 1

            sum[skill[1]][skill[2]] += skill[5] * type;
            sum[skill[1]][skill[4]+1] -= skill[5] * type;
            sum[skill[3]+1][skill[2]] -= skill[5] * type;
            sum[skill[3]+1][skill[4]+1] += skill[5] * type;
        }

        public void cumulativeSum(int[][] sum) {    // 누적합
            for(int i=0; i<sum.length; i++) {       // 좌 -> 우 누적합
                for(int j=1; j<sum[i].length; j++) {
                    sum[i][j] += sum[i][j-1];
                }
            }

            for(int i=1; i<sum.length; i++) {       // 상 -> 하 누적합
                for(int j=0; j<sum[i].length; j++) {
                    sum[i][j] += sum[i-1][j];
                }
            }
        }

        public int calculateBoard(int[][] board, int[][] sum) {
            int count = 0;
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[i].length; j++) {
                    board[i][j] += sum[i][j];
                    if(board[i][j] > 0) count++;
                }
            }
            return count;
        }

        /*
        public void printBoard(int[][] board) {
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        */
    }
}
