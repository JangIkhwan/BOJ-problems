package solving.ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob11066 {
    /*
    https://www.acmicpc.net/problem/11066

    cost_dp[i][j] : i번 파일부터 j번 파일을 하나로 드는 합쳤을 때 최소 비용
    size[i][j] : 최소 비용 구하는 과정에서 i번 파일과 j번 파일을 합쳤을 때 파일 크기

    size[i][j] = size[i][k] + size[k + 1][j] ,if i,k,j는 minVal를 가리킴
    cost_dp[i][j] = minVal(cost_dp[i][k] + cost_dp[k + 1][j] + size[i][k] + size[k + 1][j])
     */
     /*

    cost_dp[i][j] : i번 파일부터 j번 파일을 하나로 드는 합쳤을 때 드는 모든 비용의 최솟값

    cost_dp[i][j] = minVal(cost_dp[i][k] + cost_dp[k + 1][j] + mergeCost)

    prefixsum을 이용하면, mergeCost를 계산하는 시간을 줄일 수 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] sizes = new int[K + 1];
            int [][] dp = new int[K + 1][K + 1];
            for(int j = 1; j <= K; j++){
                sizes[j] = Integer.parseInt(st.nextToken());
            }
            for(int len = 2; len <= K; len++){
                for(int i = 1; i + len - 1 <= K; i++){
                    int j = i + len - 1;
                    int mergeCost = 0;
                    for(int k = i; k <= j; k++){
                        mergeCost += sizes[k];
                    }
                    int minValue = Integer.MAX_VALUE;
                    for(int k = i; k + 1<= j; k++){
                        minValue = Math.min(minValue, dp[i][k] + dp[k + 1][j] + mergeCost);
                    }
                    dp[i][j] = minValue;
                }
            }
            System.out.println(dp[1][K]);
        }
    }
}