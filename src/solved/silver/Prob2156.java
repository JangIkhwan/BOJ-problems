package solving;

import java.io.*;

public class Main {
    /*
    https://www.acmicpc.net/problem/2156

    15:20 ~

    6 10 13 9 8 1
    6 16 23 28 33 32
    6 10 19 25 31 32
    6 6  16 23 28 33


    i번째 일에

    dp[i][0] = max(dp[i -1][1], dp[i -1][2]) + wines[i] //  어제에 이어서 마신다
    dp[i][1] = dp[i - 1][2] + wines[i] // 오늘 처음 마신다
    dp[i][2] = min(dp[i-1][0 ~ 2]) // 안마신다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N + 1];
        for(int i = 1; i <= N; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[N + 1][3];
        for(int i = 1; i <= N; i++){
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + wines[i]; //  어제에 이어서 마신다
            dp[i][1] = dp[i - 1][2] + wines[i]; // 오늘 처음 마신다
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])); // 안마신다
        }
        System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
    }
}



