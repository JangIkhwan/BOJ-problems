package solved.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob7795 {
    /*
    https://www.acmicpc.net/problem/7795
    25/1/28 11:45 ~ 12:14

    1 1 3 7 8
    1 3 6
    A를 정렬한 후에 B의 각 원소에 대해서 현재 원소보다 큰 것이 A의 어느 위치에 있는지를 이분 탐색을 찾는다.
    현재 원소바다 큰 수의 개수를 모두 더하면 답이 된다.

    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 투 포인터 풀이
    public static void main(String[] args) throws IOException {
        int T;
        int a, b;
        int[] A;
        int[] B;
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            A = new int[a];
            B = new int[b];
            line = br.readLine();
            st = new StringTokenizer(line);
            for(int i = 0; i < a; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            line = br.readLine();
            st = new StringTokenizer(line);
            for(int i = 0; i < b; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);
            int start = 0;
            int end = A.length - 1;
            int pairCount = 0;
            for(int i = 0; i < B.length; i++){
                while(start <= end && A[start] <= B[i]){
                    start++;
                }
                pairCount += end - start + 1;
            }
            bw.write(Integer.toString(pairCount) + "\n");
        }
        bw.flush();
    }

    // 이진 탐색 풀이
    public static void binarySearchSolution(String[] args) throws IOException {
        int T;
        int a, b;
        int[] A;
        int[] B;
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            A = new int[a];
            B = new int[b];
            line = br.readLine();
            st = new StringTokenizer(line);
            for(int i = 0; i < a; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            line = br.readLine();
            st = new StringTokenizer(line);
            for(int i = 0; i < b; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            int pairCount = 0;
            for(int i = 0; i < b; i++){
                int ret = binarySearch(A, B[i]);
                if(ret < A.length && ret > -1){
                    pairCount += (A.length - ret);
                }
            }
            bw.write(Integer.toString(pairCount) + "\n");
        }
        bw.flush();
    }
    private static int binarySearch(int[] A, int key){
        int lo = -1;
        int hi = A.length;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(A[mid] <= key){
                lo = mid;
            }
            else{
                hi = mid;
            }
        }
        return hi;
    }
}




