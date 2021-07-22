import java.io.*;
import java.util.*;

public class paintbarn {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
        int[][] g=new int[1002][1002];
        for(int i=0;i<g.length;i++) Arrays.fill(g[i],0);
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken()),u=Integer.parseInt(st.nextToken());
            for(int j=b;j<u;j++){
                g[l][j]++;
                g[r][j]--;
            }
        }
        for(int y=0;y<1002;y++) {
            for (int x = 0; x < 1002; x++) {
                if(x>0)g[x][y] += g[x - 1][y];
            }
        }
        int ans=0;
        for(int y=0;y<1001;y++){
            for(int x=0;x<1001;x++){
                if(g[x][y]==k)ans++;
            }
        }
        System.out.println(ans);
        pw.println(ans);
        pw.close();
        br.close();
    }
}
