package solved.silver;

import java.io.*;
import java.util.Arrays;

public class Prob2839 {
    /*
    https://www.acmicpc.net/problem/2839

    25/1/28 17:45 ~

    백트래킹만 이용하니 시간 초과 발생

    DP로 해결

    f(n) : n 킬로그램을 만드는 봉지의 수 중 최솟값
    f(n) = min(f(n - 3),  f(n - 5))

    그리디 성질도 가지고 있음
    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dp;

    private static int NONE = 2000;
    private static int INF = 2000;

    // DP
    public static void main(String[] args) throws IOException {
        int N;
        N = Integer.parseInt(br.readLine());
        dp = new int[5001];
        Arrays.fill(dp, INF);
        dp[3] = 1;
        dp[5] = 1;
        for(int i = 6; i <= N; i++){
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
        if(dp[N] >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[N]);
    }

    // 메모이제이션
    public static void memoizationSolution(String[] args) throws IOException {
        int N;
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, NONE);
        int minSugarBags = findMinSugarBags(1, N);
        if (minSugarBags == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(minSugarBags);
    }

    private static int findMinSugarBags(int depth, int n){
        if(n < 0){
            return INF;
        }
        if(n == 0){
            return depth - 1;
        }
        if(dp[n] != NONE){
            return dp[n];
        }
        dp[n] = Math.min(findMinSugarBags(depth + 1, n - 5), findMinSugarBags(depth + 1, n - 3)); // 순서를 바꾸면 메모이제이션으로 답을 구하지 못할 수 있음...
        return dp[n];
    }
}




