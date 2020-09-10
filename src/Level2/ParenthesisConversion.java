package Level2;

public class ParenthesisConversion {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("()))((()");
        sol.solution(")()()()(");
        //sol.solution("())(");
        //sol.solution("()))((()))(()()(()");
    }

    static class Solution {
        public String solution(String p) {
            if (p.equals("")) return "";

            System.out.println(p + " -> " + convert(p));
            return convert(p);
        }

        public String convert(String p) {
            String u = "";
            String v = "";

            if(stringDivision(p)[1].equals("")) {
                u = stringDivision(p)[0];
                v = stringDivision(p)[1];
            } else {
                u = stringDivision(p)[0];
                v = convert(stringDivision(p)[1]);
            }

            return makeCorrectStr(u, v);
        }

        public String[] stringDivision(String p) {
            int num = 0;
            String[] str = new String[2];
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '(') {
                    num++;
                } else if (p.charAt(i) == ')') {
                    num--;
                }

                if (num == 0) {
                    str[0] = p.substring(0, i + 1);
                    str[1] = p.substring(i + 1);
                    break;
                }
            }
            return str;
        }

        public boolean isCorrect(String u) {
            int num = 0;
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    num++;
                } else if (u.charAt(i) == ')') {
                    num--;
                }

                if (num < 0) {
                    //System.out.println("균형잡힌 괄호 문자열");
                    return false;
                }
            }
            //System.out.println("올바른 괄호 문자열");
            return true;
        }

        public String makeCorrectStr(String u, String v) {
            String correctStr = "";
            String correctU = "";

            if(!isCorrect(u)) {
                correctStr += "(" + v + ")";

                if (u.length() > 2) {
                    u = u.substring(1, u.length() - 1);

                    for (int i = 0; i < u.length(); i++) {
                        if (u.charAt(i) == '(') {
                            correctU += ")";
                        } else if (u.charAt(i) == ')') {
                            correctU += "(";
                        }
                    }
                    correctStr += correctU;
                }
                //System.out.println("u가 올바르지 않은 괄호 문자열" + correctStr);
                return correctStr;
            } else {
                //System.out.println("u가 올바른 괄호 문자열" + u + v);
                return u + v;
            }
        }
    }
}
