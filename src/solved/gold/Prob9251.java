package solved.gold;

import java.io.*;

public class Prob9251 {
    /*
    https://www.acmicpc.net/problem/9251

    25/3/1 23:13 ~ 12:01

    dp[i][j] A의 i까지와 B의 j까지를 비교할 때 lcs 길이

    dp[i][j] = max(dp[i-1][j-1] + 1, dp)    i == j
    = max(dp[i - 1][j], dp[i][j-1], dp)     i != j

    1차 제출 실패
    - 초기값 설정을 잘못했음. A의 0번까지와 B의 i번까지를 비교할 때, 처음으로 매칭되어서 값이 dp값이 1로 나오면 이후의 dp 값도 1이어야 함

    2차 제출 성공
    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String A, B;
        A = br.readLine();
        B = br.readLine();
        lcs(A, B);
    }

    private static void lcs(String A, String B){
        int [][] dp;
        dp = new int[A.length()][B.length()];
        int value = 0;
        for(int i = 0; i < B.length(); i++){
            if(A.charAt(0) == B.charAt(i)){
                value = 1;
            }
            dp[0][i] = value;
        }
        value = 0;
        for(int i = 1; i < A.length(); i++){
            if(A.charAt(i) == B.charAt(0)){
                value = 1;

            }
            dp[i][0] = value;
        }
        for(int i = 1; i < A.length(); i++){
            for(int j = 1; j < B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                else{
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        System.out.println(dp[A.length() - 1][B.length() - 1]);
    }
}





