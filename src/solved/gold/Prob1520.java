package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1520 {
    /*

    24/12/21 15:25 ~

    dfs() ?
    모든 경로 찾을때까지 반복
    시간 초과 발생...

    dp를 이용 ?
    dp[i][j] : (i, j) 칸에서 목적지로 갈 수 있는 경우의 수

    이 칸에 도달했을 때 다음에 이동할 i,j 칸이 계산되어 있다면 answer += d[i][j]


4 5
50 45 37 32 30
35 50 40 20 25
30 29 24 17 28
27 24 22 15 10

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
        System.out.println(answer);
    }

    public static int dfs(int curX, int curY){
        if(curX == N && curY == M) {
            answer++;
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
                answer += dp[ny][nx];
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

    public static void dfs0(int curX, int curY){
        if(curX == N && curY == M) {
            answer++;
        }
        for(int direct = 0; direct < 4; direct++){
            int nx = curX + dx[direct];
            int ny = curY + dy[direct];
            if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
            if(map[ny][nx] >= map[curY][curX]) continue;
            if(!visited[ny][nx]){
                visited[ny][nx] = true;
                dfs0(nx, ny);
                visited[ny][nx] = false;
            }
        }
    }
}
