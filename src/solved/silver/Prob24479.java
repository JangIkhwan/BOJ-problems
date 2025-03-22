package solved.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Prob24479 {
    /*
    https://www.acmicpc.net/problem/24479

    2025/01/01 20:37 ~ 21:10

    1. 풀이 과정
    dfs를 이용하면 될 듯.
    방문순서 배열을 0으로 초기화.
    dfs를 구현해서 1을 시작으로 방문 가능한 노드들의 방문 순서를 배열에 저장.

    2. 한 번 틀린 이유
    visitNumber를 계속 증가시켜야 하는데 dfs()의 매개변수인 상태에서는 한 가지에서 다른 가지로 넘어갈 때 증가시킬 수 없음.
    그래서 visitNumber를 전역변수로 수정함

    반례
    1 - 2 - 3 - 4
          \
            5
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, R;
    private static List<Integer>[] graph;

    private static int [] visited;

    private static int visitNumber = 1;
    public static void main(String[] args) throws IOException {
        init();
        dfs(R);
        for(int i = 1; i <= N; i++){
            bw.write(visited[i] + "\n");
        }
        bw.flush();
    }

    public static void init() throws IOException {
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++){
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }
        visited = new int[N + 1];
    }

    public static void dfs(int cur) {
        visited[cur] = visitNumber++;
        for(int next : graph[cur]){
            if(visited[next] == 0){
                dfs(next);
            }
        }
    }
}



