import java.io.*;
import java.util.*;

public class perimeter {
    static char[][] grid;
    static int n;
    static class group{
        int size;
        int peri;
        group(){size=0;peri=0;}
    }
    static group[] g;
    static int[][] visited;
    static void dfs(int i,int j,int gn){
        if(i<0||i>=n||j<0||j>=n||visited[i][j]!=-1||grid[i][j]=='.') return;
        visited[i][j]=gn;
        g[gn].size++;
        if(i-1>=0&&visited[i-1][j]==-1&&grid[i-1][j]=='#') dfs(i-1,j,gn);
        if(i+1<n&&visited[i+1][j]==-1&&grid[i+1][j]=='#') dfs(i+1,j,gn);
        if(j-1>=0&&visited[i][j-1]==-1&&grid[i][j-1]=='#') dfs(i,j-1,gn);
        if(j+1<n&&visited[i][j+1]==-1&&grid[i][j+1]=='#') dfs(i,j+1,gn);

        if(i==0||(i-1>=0&&grid[i-1][j]=='.')) g[gn].peri++;
        if(i==n-1||(i+1<n&&grid[i+1][j]=='.')) g[gn].peri++;
        if(j==0||(j-1>=0&&grid[i][j-1]=='.')) g[gn].peri++;
        if(j==n-1||(j+1<n&&grid[i][j+1]=='.')) g[gn].peri++;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        n=Integer.parseInt(br.readLine());
        grid=new char[n][n];
        g=new group[n*n];
        for(int i=0;i<n*n;i++)
            g[i]=new group();

        visited=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(visited[i],-1);

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int gc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='#'&&visited[i][j]==-1){
                    gc++;
                    dfs(i,j,gc);
                }
            }
        }
        Arrays.sort(g,(a1,a2)->a1.size==a2.size? a1.peri-a2.peri:a2.size-a1.size);
        pw.println(g[0].size+" "+g[0].peri);
        pw.close();
        //System.out.println(g[0].size+" "+g[0].peri);
        br.close();
    }
}
