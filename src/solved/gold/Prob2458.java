package solved.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2458 {
    /*
    https://www.acmicpc.net/problem/2458

    25/3/22 23:20 ~ 23:45

    한 정점과 다른 모든 정점 사이에 경로가 존재하면 그것의 순서를 결정할 수 있음.

    플로이드 워셜을 이용하면 모든 정정 쌍 사이의 도달가능성을 빠르게 구할 수 있을 것 같음

    dp[k][i][j] = dp[k-1][i][k] + dp[k - 1][k][j], dp[k-1][i][j]
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;

    private static int [][] dp;

    private static final int INF = 1000;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dp[i], INF);
        }
        for(int i = 1; i <= M; i++){
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[a][b] = 1;
        }
    }

    private static void solve() {
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(canFindSequence(i)){
                answer++;
            }
        }
        System.out.println(answer);
    }


    private static boolean canFindSequence(int one){
        for(int another = 1; another <= N; another++){
            if(another != one && dp[one][another] == INF && dp[another][one] == INF){
                return false;
            }
        }
        return true;
    }

}
