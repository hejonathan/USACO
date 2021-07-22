import java.io.*;
import java.util.*;

public class ccski {
    static int[][] map;
    static int[][] wp;
    static int[] start=new int[2];
    static int m,n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("ccski.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        map=new int[m][n];
        wp=new int[m][n];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //System.out.print(map[i][j]+" ");
            }
            //System.out.println();
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                wp[i][j] = Integer.parseInt(st.nextToken());
                if(wp[i][j]==1){start[0]=i;start[1]=j;}
            }
        }
        //System.out.println(reach(40));
        int ans=bs();
        //System.out.println(ans);
        pw.println(ans);
        pw.close();
        br.close();
    }
    static int bs(){
        int l=0,h=(int)Math.pow(10,9);
        while(l<h){
            int d=l+(h-l)/2;
            if(reach(d))h=d;
            else l=d+1;
        }
        return l;
    }
    static boolean reach(int d){
        boolean[][] visited=new boolean[m][n];
        //for(int i=0;i<m;i++)Arrays.fill(visited[i],false);
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(start[0], start[1]));
        while(!q.isEmpty()){
            pair temp=q.remove();
            if(visited[temp.i][temp.j])continue;
            visited[temp.i][temp.j]=true;
            //System.out.println(map[temp.i][temp.j]);
            if(temp.i-1>=0 && Math.abs(map[temp.i][temp.j]-map[temp.i-1][temp.j])<=d &&!visited[temp.i-1][temp.j]) q.add(new pair(temp.i-1,temp.j));
            if(temp.i+1<m && Math.abs(map[temp.i][temp.j]-map[temp.i+1][temp.j])<=d &&!visited[temp.i+1][temp.j]) q.add(new pair(temp.i+1,temp.j));
            if(temp.j-1>=0 && Math.abs(map[temp.i][temp.j]-map[temp.i][temp.j-1])<=d &&!visited[temp.i][temp.j-1]) q.add(new pair(temp.i,temp.j-1));
            if(temp.j+1<n && Math.abs(map[temp.i][temp.j]-map[temp.i][temp.j+1])<=d &&!visited[temp.i][temp.j+1]) q.add(new pair(temp.i,temp.j+1));
        }
        boolean ret=true;
        //for(int i=0;i<m;i++) System.out.println(Arrays.toString(visited[i]));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(wp[i][j]==1&&!visited[i][j]){ret=false;break;}
            }
        }
        return ret;
    }
    static class pair{
        int i,j;
        pair(int a,int b){i=a;j=b;}
    }
}
