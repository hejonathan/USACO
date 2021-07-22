import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cowntagion {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int days;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        adj = new ArrayList[n+1];
        visited=new boolean[n+1];
        days=0;
        for(int i=1;i<=n;i++)adj[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<Integer> q =new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int temp=q.remove();
            if(visited[temp])continue;
            visited[temp]=true;
            //count unvisited neighbors
            int goodnb=0;
            for(int e:adj[temp]){
                if(!visited[e])goodnb++;
            }
            //goodnb=adj[temp].size()-1;
            //count how many days to double to goodnb
            days+=count(goodnb+1);
            //System.out.println(temp+" "+count(goodnb+1)+" "+goodnb);
            //System.out.println("days = " + days);
            for(int e:adj[temp]){
                if(!visited[e]){
                    days++;
                    //System.out.println(e);
                    q.add(e);
                }
            }
        }
        System.out.println(days);
    }
    static int count (int goodnb){
        if(goodnb==0)return 0;
        if(goodnb==1)return 0;
        double d=Math.log(goodnb)/Math.log(2);
        return (int)(Math.ceil(d));
    }
}
