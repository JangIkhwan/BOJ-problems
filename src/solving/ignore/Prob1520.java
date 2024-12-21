package solving.ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1520 {
    /*
    https://www.acmicpc.net/problem/1520

    24/11/24 21:15 ~

    dp[i][j] : i행 j열까지 올 수 있는 경로의 수
    dp[i][j] = dp[i - 1][j] + d[i][j - 1];
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M + 1][N + 1];
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = 1;
        boolean decreasing = true;
        for(int row = 2; row <= M; row++){
            if(decreasing){
                dp[row][1] = 1;
                if(row + 1 <= M && map[row][1] < map[row + 1][1]){
                    decreasing = false;
                }
            }
        }
        decreasing = true;
        for(int col = 2; col <= N; col++){
            if(decreasing){
                dp[1][col] = 1;
                if(col + 1 <= N && map[1][col] < map[1][col + 1]){
                    decreasing = false;
                }
            }
        }
        for(int row = 2; row <= M; row++){
            for(int col = 2; col <= N; col++){
                int routeNumber = 0;
                if(map[row - 1][col] > map[row][col]) routeNumber += dp[row - 1][col];
                if(map[row][col - 1] > map[row][col]) routeNumber += dp[row][col - 1];
                dp[row][col] = routeNumber;
            }
        }
        System.out.println(dp[M][N]);
    }
}