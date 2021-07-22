import java.io.*;
import java.util.StringTokenizer;

public class DigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        if(9*m<n || (n<1&&m!=1)){
            System.out.println(-1);
            return;
        }
        for(int i=0;i<m;i++){
            int a = Math.min(9,n);
            n-=a;
            System.out.print(a);
        }
        System.out.println();
        return;

    }
}
