package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1520 {
    /*

    24/12/21 15:25 ~ 17:00

    유형 : dfs, DP

    풀이 과정

    1. dfs()로 경로 개수 세기
    모든 경로 찾을때까지 반복
    시간 초과 발생...

    2. dp를 이용하여 최적화
    이미 목적지로 가는 경로의 수가 계산된 칸이 있다면,
     그 칸을 방문하지 않아도 저장된 값으로 현재 칸에서 목적지로 가는 경로의 수를 계산할 수 있음

    dp[i][j] : (i, j) 칸에서 목적지로 갈 수 있는 경우의 수

    현재 칸에 저장할 dp값이 routes라고 하자.
    다음 칸으로 가는 값이 계산되어 있다면, routes += dp[i][j]
    그렇지 않다면, routes += dfs(i, j)

    전체 답은 dp[1][1]에 저장된다.

예시 입력

4 5
50 45 37 32 30
35 50 40 20 25
30 29 24 17 28
27 24 22 15 10

답 : 6

     */
    private static int M, N, answer = 0;
    private static int [][] map;
    private static int [][] dp;
    private static boolean[][] visited;
    private static int [] dx = {-1, 0, 1, 0};
    private static int [] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];
        for(int i = 1; i <= M; i++)
            Arrays.fill(dp[i], -1);
        for(int y = 1; y <= M; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= N; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 1);
        System.out.println(dp[1][1]);
    }

    public static int dfs(int curX, int curY){
        if(curX == N && curY == M) {
            return 1;
        }
        int reachableroutes = 0;
        for(int direct = 0; direct < 4; direct++){
            int nx = curX + dx[direct];
            int ny = curY + dy[direct];
            if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
            if(map[ny][nx] >= map[curY][curX]) continue;
            if(dp[ny][nx] != -1){
                reachableroutes += dp[ny][nx];
            }
            else{
                if(!visited[ny][nx]){
                    visited[ny][nx] = true;
                    reachableroutes += dfs(nx, ny);
                    visited[ny][nx] = false;
                }
            }
        }
        dp[curY][curX] = reachableroutes;
        return reachableroutes;
    }
}
