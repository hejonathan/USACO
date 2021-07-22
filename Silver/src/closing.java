import java.io.*;
import java.util.*;

public class closing {
    static void union_init(int d[]) { for (int i=0; i < d.length; i++) d[i]=i; }
    static int union_query(int d[], int n) { int res=n; while (d[res]!=res) res=d[res]; int m; while (d[n]!=n) {m=d[n];d[n]=res;n=m;} return res; };
    static int union_merge(int d[], int x, int y) { x=union_query(d,x); y=union_query(d,y); if (x==y)return -1; d[x]=y; return 1; }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("closing.in"));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        List<Integer>[] adj=new ArrayList[n+1];
        for(int i=0;i<n+1;i++) adj[i]=new ArrayList<>();
        int[][] p=new int[m][2];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            p[i][0]=Integer.parseInt(st.nextToken());
            p[i][1]=Integer.parseInt(st.nextToken());
        }
        int[] order=new int[n+1];
        int[] place=new int[n+1];
        for(int i=n;i>0;i--){
            order[i]=Integer.parseInt(br.readLine());
            place[order[i]]=i;
        }
        for(int[] e:p){
            if(place[e[0]]>place[e[1]])adj[e[0]].add(e[1]);
            else adj[e[1]].add(e[0]);
        }
        int[] d=new int[n+1];
        union_init(d);
        int groups=0;
        List<Boolean> ret=new ArrayList<>();
        for(int i=1;i<order.length;i++){
            groups++;
            for(int e:adj[order[i]]){
                if(union_query(d,e)!=union_query(d,order[i])){
                    union_merge(d,e,order[i]);
                    groups--;
                }
            }
            ret.add(groups<=1);
        }
        Collections.reverse(ret);
        for(boolean e:ret){
            if(e) pw.println("YES");
            else pw.println("NO");
        }
        /*for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        boolean[] closed=new boolean[n+1];
        Arrays.fill(closed,false);
        for(int i=0;i<n;i++){
            boolean[] visited=new boolean[n+1];
            Arrays.fill(visited,false);
            Queue<Integer> q=new LinkedList<>();
            for(int j=1;j<=n;j++) {
                if (!closed[j]) {
                    q.add(j);
                    break;
                }
            }
            while(!q.isEmpty()){
                int temp=q.poll();
                if(visited[temp]||closed[temp]) continue;
                visited[temp]=true;
                for(int e:adj[temp]) {
                    if(!visited[e]&&!closed[e]) q.add(e);
                }
            }
            boolean reach=true;
            for(int j=1;j<=n;j++){
                if(!closed[j] && !visited[j]) {
                    reach=false;
                }
            }
            if(reach){
                pw.println("YES");
                //System.out.println("YES");
            }else{
                pw.println("NO");
                //System.out.println("NO");
            }
            closed[Integer.parseInt(br.readLine())]=true;
        }*/
        pw.close();
        br.close();
    }

}
