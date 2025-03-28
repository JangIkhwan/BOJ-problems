package solved.bronze;

import java.io.*;

public class Prob2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int stars = 1; stars <= N; stars++){
            for(int i = 1; i <= N - stars; i++){
                bw.write(" ");
            }
            for(int i = 1; i <= stars; i++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}



