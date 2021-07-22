import java.io.*;
import java.util.*;

public class lightson {
    static class pair{
        int x;
        int y;
        pair(int a,int b){
            x=a;y=b;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pair pair = (pair) o;
            return x == pair.x &&
                    y == pair.y;
        }
    }
    static boolean[][] visited;
    static boolean[][] lighton;
    static Set<pair>[][] togl;
    static boolean[][] reach;
    static int[] a=new int[500000];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        togl=new HashSet[n+1][n+1];
        visited=new boolean[n+1][n+1];
        lighton=new boolean[n+1][n+1];
        reach=new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)togl[i][j]=new HashSet<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            togl[x][y].add(new pair(a,b));
        }
        lighton[1][1]=true;
        reach[1][1]=true;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(1,1));
        while(!q.isEmpty()){
            pair temp=q.remove();
            int x=temp.x;
            int y=temp.y;
            if(x<1||y<1||x>=visited.length||y>=visited[0].length||visited[x][y]||!lighton[x][y])continue;
            visited[x][y]=true;
            System.out.println(x+" "+y);
            if(!togl[x][y].isEmpty())
                for(pair e:togl[x][y]){
                    lighton[e.x][e.y]=true;
                    //System.out.println(x+" "+y+" "+e.x+" "+e.y);
                }
            if(x>1)reach[x-1][y]=true;
            if(y>1)reach[x][y-1]=true;
            if(x<lighton.length-1)reach[x+1][y]=true;
            if(y<lighton[0].length-1)reach[x][y+1]=true;

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(!visited[i][j]&&lighton[i][j]&&reach[i][j])q.add(new pair(i,j));
                }
            }
        }
        int sum=0;
        for(boolean[] e:lighton){
            for(boolean f:e) if(f)sum++;
        }
        pw.println(sum);
        pw.close();
        br.close();
    }
    static void dfs(int x,int y){
        if(x<1||y<1||x>=visited.length||y>=visited[0].length||visited[x][y]||!lighton[x][y])return;
        visited[x][y]=true;
        if(!togl[x][y].isEmpty())
            for(pair e:togl[x][y]){
                lighton[e.x][e.y]=true;
                System.out.println(x+" "+y+" "+e.x+" "+e.y);
            }
        if(x>1&&lighton[x-1][y]&&!visited[x-1][y])dfs(x-1,y);
        if(y<visited[0].length-1&&lighton[x][y+1]&&!visited[x][y+1])dfs(x,y+1);
        if(x<visited.length-1&&lighton[x+1][y]&&!visited[x+1][y])dfs(x+1,y);
        if(y>1&&lighton[x][y-1]&&!visited[x][y-1])dfs(x,y-1);

    }
}