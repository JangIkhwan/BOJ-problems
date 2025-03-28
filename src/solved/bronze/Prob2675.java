package solved.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Prob2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                for(int j = 0; j < R; j++)
                    sb.append(str.substring(i, i + 1));
            }
            bw.write(sb.toString());
            bw.write("\n");
        }
        bw.flush();
    }
}



