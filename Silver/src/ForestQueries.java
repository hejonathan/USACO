import java.io.*;
import java.util.*;
public class ForestQueries {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),q=Integer.parseInt(st.nextToken());
        int[][] g=new int[n+1][n+1];
        for(int i=0;i<g.length;i++) Arrays.fill(g[i],0);
        for(int i=1;i<=n;i++){
            String t=br.readLine();
            for(int j=1;j<=n;j++){
                char a=t.charAt(j-1);
                if(a=='*')g[i][j]=1;
                else g[i][j]=0;
            }
        }
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++){
                g[i][j]+=g[i-1][j]+g[i][j-1]-g[i-1][j-1];
            }
        for(int i=1;i<=q;i++){
            st=new StringTokenizer(br.readLine());
            int y1=Integer.parseInt(st.nextToken()),x1=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken()),x2=Integer.parseInt(st.nextToken());
            int ans=g[y2][x2]-g[y2][x1-1]-g[y1-1][x2]+g[y1-1][x1-1];
            System.out.println(ans);
        }
    }
}
