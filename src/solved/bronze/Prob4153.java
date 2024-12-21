package solving;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /*

    https://www.acmicpc.net/problem/4153

    24/12/21 19:30 ~ 19:42

    1. 풀이 과정>>
    직각삼각형에서 직각의 대변을 찾기만 하면 된다.
    하드코딩하거나 정렬을 이용하여 대변을 구하면 된다.

    2. 새로 배운 점>>
    BufferedWriter는 버퍼를 사용해야 하기 때문에 출력 시점에 flush()를 사용해야 한다.
    BufferedWriter의 write()를 이용해 개행을 해야할 때는 /n 문자를 사용한다.

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String line = br.readLine();
            if(line.equals("0 0 0")){
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a >= b && a >= c){
                int temp = a;
                a = c;
                c = temp;
            }
            else if (b >= a && b >= c){
                int temp = b;
                b = c;
                c = temp;
            }
            if(c * c == a * a + b * b){
                bw.write("right\n");
            }
            else{
                bw.write("wrong\n");
            }
        }
        bw.flush();
    }
}