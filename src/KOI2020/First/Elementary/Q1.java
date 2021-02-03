package KOI2020.First.Elementary;

import java.io.*;

/**
 * 박 터뜨리기
 */

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0; i<input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(new Solution().solution(arr));

        br.close();
    }

    static class Solution {
        public int solution(int[] arr) {
            int n = arr[0];
            int k = arr[1];

            if(sum(k) > n)
                return -1;

            return (n - sum(k)) % k == 0 ? k - 1 : k;
        }

        public int sum(int k) {
            return k * (k + 1) / 2;
        }
    }

    //1, 2, 3, 4, 5, 6 --> 21 6 / 0
    //1, 2, 3, 4, 5, 7 --> 22 6 / 1
    //1, 2, 3, 4, 6, 7 --> 23 6 / 2
    //1, 2, 3, 5, 6, 7 --> 24 6 / 3
    //1, 2, 4, 5, 6, 7 --> 25 6 / 4
    //1, 3, 4, 5, 6, 7 --> 26 6 / 5
    //2, 3, 4, 5, 6, 7 --> 27 6 / 6 % 6 = 0
    //2, 3, 4, 5, 6, 8 --> 28 6 / 7 % 6


    //모범 코드
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;

        n -= k * (k + 1) / 2;

        if(n < 0) ans = -1;
        else if(n % k == 0) ans = k - 1;
        else ans = k;

        System.out.println(ans);
    }*/
}