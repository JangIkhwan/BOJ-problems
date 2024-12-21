package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    https://www.acmicpc.net/problem/14501

    dp[i][] : i일부터 안겹치게 일해서 벌 수 있는 최대 이익

    dp[i] = profits[i] + dp[i + times[i]]

    3	5	1	1	2	4	2
    10	20	10	20	15	40	200
    35  20  45  35  15   0    0
    
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N + 1];
        int[] profits = new int [N + 1];
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i = N; i >= 1; i--){
            if(i + times[i] <= N) dp[i] = profits[i] + dp[i + times[i]];
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        System.out.println(maxProfit);
    }

    public void fail() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] durations = new int[N + 1];
        int[] earnings = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++){
            String line = br.readLine();
            st = new StringTokenizer(line);
            durations[i] = Integer.parseInt(st.nextToken());
            earnings[i] = Integer.parseInt(st.nextToken());
        }
        for(int day = 1; day <= N; day++){
            dp[day] = dp[day - 1];
            for(int pastDay = 1; pastDay < day; pastDay++){
                if(durations[pastDay] == day - pastDay){
                    dp[day] = Math.max(dp[day], dp[pastDay - 1] + earnings[pastDay]);
                }
            }
            if(durations[day] == 1) dp[day] += earnings[day];
        }
        System.out.println(dp[N]);
    }
}