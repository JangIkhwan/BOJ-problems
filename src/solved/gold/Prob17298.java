package solved.gold;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob17298 {
    /*
    https://www.acmicpc.net/problem/17298

    25/1/30 23:00 ~ 23:20

    N log N의 알고리즘을 찾아야 함
    수가 감소하는 구간에서는 오큰수를 계산하지 못함. 구간 이후에 처음으로 큰 수가 나타나면 그제서야 구간의 오른쪽 일부만 오큰수를 구할 수 있음.
    스택에 감소하는 구간의 수들을 저장해놓는다면 오큰수를 효율적으로 계산할 수 있을 것임

    의사코드
    현재 숫자가 스택의 top보다 크면, top이 작아질때까지 삭제하면서 오큰수 계산함.
    현재 숫자가 top보다 작거나 같으면 스택에 삽입해서 계산을 미룸
    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N;
        int[] A;
        int[] nge;
        Stack<Integer> st = new Stack<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer strTok = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(strTok.nextToken());
        }
        nge = new int[N];
        st.push(0);
        for(int i = 1; i < N; i++){
            if(A[st.peek()] >= A[i]){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && A[st.peek()] < A[i]){
                    int top = st.pop();
                    nge[top] = A[i];
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            int top = st.pop();
            nge[top] = -1;
        }
        for(int i = 0; i < N; i++){
            bw.write(Integer.toString(nge[i]) + " ");
        }
        bw.flush();
    }
}




