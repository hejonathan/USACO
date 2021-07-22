import java.io.*;
import java.util.*;

public class maxcross {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
        int[] p=new int[n+1];
        Arrays.fill(p,1);
        p[0]=0;
        for(int i=1;i<=b;i++){
            p[Integer.parseInt(br.readLine())]=0;
        }
        for(int i=1;i<p.length;i++){
            p[i]=p[i-1]+p[i];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i+k<p.length;i++){
            int broken=k-(p[i+k]-p[i]);
            ans=Math.min(ans,broken);
        }
        pw.println(ans);
        pw.close();
        br.close();
    }
}
