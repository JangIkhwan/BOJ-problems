package solved.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2110 {
    /*
   https://www.acmicpc.net/problem/2110

   25/2/14 21:02 ~ 21:48

   1 2 4 8 9

   Length 이상의 거리로 떨어뜨려놓을 수 있는가?

   첫집에서 놓기 시작하면 불가능한데 다음집에서 시작하면 되는 경우가 있는가?
    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, C;
    private static int[] houses;

    private static int minimumDist = 2123456789;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMaximumDist());
    }

    private static void init() throws IOException {
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        for(int i = 0; i < N; i++){
            line = br.readLine();
            houses[i] = Integer.parseInt(line);
        }
        Arrays.sort(houses);
        for(int i = 1; i < N; i++){
            int dist = houses[i] - houses[i - 1];
            if(minimumDist > dist){
                minimumDist = dist;
            }
        }
    }

    private static int findMaximumDist(){
        int lo = minimumDist;
        int hi = houses[N - 1] - houses[0] + 1;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(canPlaceAccessPoints(mid)){
                lo = mid;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean canPlaceAccessPoints(int length){
        int accessPointNumber = 1;
        int dist = 0;
        for(int current = 1; current < N; current++){
            dist += houses[current] - houses[current - 1];
            if(dist >= length){
                accessPointNumber++;
                dist = 0;
            }
            if(accessPointNumber >= C){
                return true;
            }
        }
        return false;
    }
}





