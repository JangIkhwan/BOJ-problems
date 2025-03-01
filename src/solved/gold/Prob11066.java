package solved.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob11066 {
    /*
    https://www.acmicpc.net/problem/11066

    25/3/1 12:36 ~ 13:26

    1차 시도 실패 : 풀이 시간 지체

    25/3/2 00:19 ~ 00:42

    2차 시도 성공

    dp[i][j] : i장부터 j장까지 합치는데 들었던 누적 비용 중 최솟값

    dp[i][j] = min( dp[i][k] + dp[k+1][j] + sumOfInteval )  i <= k <= j - 1      // i != j
             = 0                                                                 // i == j

    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T;
        T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            int K = Integer.parseInt(br.readLine());
            int [] chapters = new int[K + 1];
            int [] sum = new int[K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++){
                chapters[i] = Integer.parseInt(st.nextToken());
                sum[i] += sum[i - 1] + chapters[i];
            }
            int[][] dp = new int[K + 1][K + 1];
            for(int i = 1; i <= K; i++) {
                Arrays.fill(dp[i], -1);
                dp[i][i] = 0;
            }
            for(int len = 2; len <= K; len++){
                for(int i = 1; i + len - 1 <= K; i++){
                    int j = i + len - 1;
                    for(int k = i; k + 1 <= j; k++){
                        if(dp[i][j] == -1) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1];

                        }
                        else{
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                        }
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }
}





