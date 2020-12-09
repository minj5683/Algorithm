package Level2;

import java.util.Vector;

/**
 * [2020 카카오 인턴십] 수식 최대화
 */

public class MaximizeFormula {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String exp = "100-200*300-500+20";
        String exp2 = "50*6-3*2";

        sol.solution(exp);
        sol.solution(exp2);
    }

    // 수식에는 적어도 1개 이상의 연산자
    // 피연산자는 999이하인 양수
    // 수식 결과값의 절댓값 중 가장 큰 숫자를 리턴
    static class Solution {
        long answer = 0;

        public long solution(String expression) {
            answer = 0;

            // expression 의 연산자와 피연산자를 exp 에 삽입
            Vector<String> exp = new Vector<>();
            int idx = 0;
            for(int i=0; i<expression.length(); i++) {
                if (0 > expression.charAt(i) - '0' || expression.charAt(i) - '0' > 999) {
                    exp.add(expression.substring(idx, i));
                    exp.add(expression.substring(i, i+1));
                    idx = i+1;
                }
            }
            exp.add(expression.substring(idx));

            /*for(String s : exp) System.out.print(s + " ");
            System.out.println();*/

            String[] operator = { "*", "+", "-" };
            String[] output = new String[operator.length];
            boolean[] visited = new boolean[operator.length];
            permutation(exp, operator, output, visited, 0, operator.length);

            System.out.println(answer);
            return answer;
        }

        // arr 배열에서 n개의 값을 순서대로 뽑는 경우
        public void permutation(Vector<String> expression, String[] arr, String[] output, boolean[] visited, int depth, int n) {
            if (depth == n) {
                calculate(expression, output);
                return;
            }

            for (int i=0; i<n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = arr[i];
                    permutation(expression, arr, output, visited, depth + 1, n);
                    visited[i] = false;;
                }
            }

        }


        public void calculate(Vector<String> expression, String[] arr) {
            //for (String j : arr) System.out.print(j + " ");

            Vector<String> exp = new Vector<>(expression);

            for (String op : arr) {
                for (int j = 0; j < exp.size(); j++) {
                    if (exp.get(j).equals(op)) {

                        long res = switch (op) {
                            case "*" -> Long.parseLong(exp.get(j - 1)) * Long.parseLong(exp.get(j + 1));
                            case "+" -> Long.parseLong(exp.get(j - 1)) + Long.parseLong(exp.get(j + 1));
                            case "-" -> Long.parseLong(exp.get(j - 1)) - Long.parseLong(exp.get(j + 1));
                            default -> 0;
                        };

                        exp.removeElementAt(j - 1);
                        exp.removeElementAt(j - 1);
                        exp.removeElementAt(j - 1);
                        exp.add(j - 1, res + "");
                        j--;

                    }
                }
            }

            //System.out.print("= " + Math.abs(Long.parseLong(exp.get(0))));
            //System.out.println();

            if(answer < Math.abs(Long.parseLong(exp.get(0)))) answer = Math.abs(Long.parseLong(exp.get(0)));
        }

    }
}
