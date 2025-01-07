package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob13305 {
    /*
    https://www.acmicpc.net/problem/13305

    25/01/07 15:33 ~  16:02
    성공까지 걸린 시도 : 1회
    유형 : 그리디

    1. 풀이
    그리디 성질 : 이용한 주유소들의 가격 리스트는 단조감소해야 비용이 최소이다
    만약 위의 주장이 거짓이라고 하자.
    최근 주유소보다 더 비싼 주유소를 고르는 것보다는, 그 주유소와 가격이 같거나 더 싼 주유소를 고르는 것이 비용이 더 작다.
    따라서 가정과 모순이니 주장이 참.

    2. 시행착오
    가격과 비용이 각각 최대 10억이니 총 비용은 최대 10^18이다.
    그러므로 계산에 사용되는 값은 long이어야 한다.
    중간에 값을 계산할 때도  계산에 참여하는 변수 중 하나가 long이어야 한다.
    그래서 입력값 배열을 long타입으로 바꾸었다.
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] distances = new long[N];
        long[] prices = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N -1; i++){
            distances[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            prices[i] = Long.parseLong(st.nextToken());
        }
        long totalCost = 0;
        long minPrice = prices[1];
        for(int city = 1; city < N; city++){
            if(prices[city] < minPrice) minPrice = prices[city];
            totalCost += minPrice * distances[city];
        }
        System.out.println(totalCost);
    }

}



