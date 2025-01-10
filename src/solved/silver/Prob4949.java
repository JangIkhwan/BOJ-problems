package solved.silver;

import java.io.*;
import java.util.Stack;

public class Prob4949 {
    /*
    https://www.acmicpc.net/problem/4949

    25/01/10 17:50 ~ 18:06

    유형 : 스택
    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        while(true){
            Stack<Character> st = new Stack<>();
            String line = br.readLine();
            if(line.equals(".")){
                break;
            }
            boolean isBalanced = true;
            for(int i = 0; i < line.length(); i++){
                char ch = line.charAt(i);
                if(ch == '(' || ch == '['){
                    st.push(ch);
                }
                else if(ch == ')'){
                    if(st.empty() || st.peek() != '('){
                        isBalanced = false;
                        break;
                    }
                    st.pop();
                }
                else if(ch == ']'){
                    if(st.empty() || st.peek() != '['){
                        isBalanced = false;
                        break;
                    }
                    st.pop();
                }
            }
            if(!st.empty()){
                isBalanced = false;
            }
            if(isBalanced){
                bw.write("yes\n");
            }
            else{
                bw.write("no\n");
            }
            bw.flush();
        }
    }
}



