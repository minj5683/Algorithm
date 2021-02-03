package KOI2020.First.Elementary;

import java.io.*;

/**
 * 피자 오븐
 */

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        Solution sol = new Solution();
        for (int num : input) {
            System.out.println(sol.solution(num));
        }
    }

    static class Solution {
        public String solution(int num) {
            int ADDH, ADDT, MINT, ADDO, MINO;
            ADDH = ADDT = MINT = ADDO = MINO = 0;

            ADDH = num / 60;
            num %= 60;
            if(num > 35) {
                ADDH++;
                MINT = 6 - (num + 5) / 10;
                num %= 10;
                if(num >= 5) {
                    MINO = 10 - num;
                } else {
                    ADDO = num;
                }
            } else {
                ADDT = (num + 4) / 10;
                num %= 10;
                if(num >= 6) {
                    MINO = 10 - num;
                } else {
                    ADDO = num;
                }
            }

            return ADDH + " " + ADDT + " " + MINT + " " + ADDO + " " + MINO;
        }
    }

    //모범 코
    /*public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            int a,b,c,d,e;
            a = b = c = d = e = 0;
            a += n/60;
            n%=60;
            if(n>35){
                a++;
                c = 6-(n+5)/10;
                n %= 10;
                if(n>=5){
                    e += 10-n;
                }
                else{
                    d += n;
                }
            }
            else{
                b = (n+4)/10;
                n %= 10;
                if(n>=6){
                    e += 10-n;
                }
                else{
                    d += n;
                }
            }
            System.out.print(a+" "+b+" "+c+" "+d+" "+e+"\n");
        }
    }*/
}
