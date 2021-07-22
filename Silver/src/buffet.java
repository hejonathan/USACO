import java.io.*;
import java.util.*;

public class buffet {
    static int n,E;
    static ArrayList<Integer>[] adj;
    static int[] q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("buffet.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buffet.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        adj=new ArrayList[n];
        q=new int[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            q[i]=Integer.parseInt(st.nextToken());
            int t=Integer.parseInt(st.nextToken());
            for(int j=0;j<t;j++) adj[i].add(Integer.parseInt(st.nextToken())-1);
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            boolean[] visited=new boolean[n];
            //System.out.println(i);
            ans=Math.max(ans,dfs(i,0, 0,visited,-1));
            //System.out.println();
        }
        pw.println(ans);
        pw.close();
        br.close();
        //System.out.println(ans);
    }
    static int dfs(int i, int k, int e,boolean[] visited,int last){
        if(e<0)return 0;
        //System.out.print(i+" ");
        //choose eat or not eat
        //not eat:
        int max=e;
        for(int a:adj[i]) {
            if(a!=last)
                max = Math.max(max, dfs(a, k, e - E, visited,i));
        }
        //System.out.println(Arrays.toString(visited));
        //eat:
        if(!visited[i]&&k<q[i]){//has higher quality
            e+=q[i];
            k=q[i];
            visited[i]=true;
            max=Math.max(e,max);
            for(int a:adj[i]){
                max=Math.max(max,dfs(a,k,e-E,visited,-1));
            }
        }
        visited[i]=false;
        return max;
    }
}
