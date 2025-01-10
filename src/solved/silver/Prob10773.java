package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob10773 {
    /*
    https://www.acmicpc.net/problem/10773

    25/01/10 17:40 ~ 17:47

    유형 : 스택
    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < K; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                st.pop();
            }
            else{
                st.push(number);
            }
        }
        int sum = 0;
        while(!st.empty()){
            int number = st.pop();
            sum += number;
        }
        System.out.println(sum);
    }
}



