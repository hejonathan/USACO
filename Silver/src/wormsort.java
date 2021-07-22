import java.io.*;
import java.util.*;

public class wormsort {
    static int n,m;
    static int[] group;
    static int[] go;
    static List<pair>[] adj;
    static class pair{
        int d,w;
        pair(int dest,int width){d=dest;w=width;}
    }
    static boolean reach(int min){
        Arrays.fill(group,-1);
        int cg=0;
        for(int i=1;i<=n;i++){
            if(group[i]!=-1) continue;
            cg++;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int temp=q.poll();
                if(group[temp]!=-1)continue;
                group[temp]=cg;
                for(pair e:adj[temp]){
                    if(group[e.d]==-1&&e.w>=min) q.add(e.d);
                }
            }
        }
        boolean ret=true;
        for(int i=1;i<go.length;i++){
            if(group[i]!=group[go[i]]) ret=false;
        }
        return ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());m=Integer.parseInt(st.nextToken());
        go=new int[n+1];
        group=new int[n+1];
        adj=new ArrayList[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int a=Integer.parseInt(st.nextToken());
            go[i]=a;
            adj[i]=new ArrayList<>();
        }
        boolean sorted=true;
        for(int i=1;i<go.length;i++){
            if(go[i]!=i){
                sorted=false;
                break;
            }
        }
        if(sorted){
            pw.println(-1);pw.close();br.close();return;
        }
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken()),w=Integer.parseInt(st.nextToken());
            adj[a].add(new pair(b,w));
            adj[b].add(new pair(a,w));
        }
        int l=1,h=(int)1e9;
        while(l<h){
            int mid=l+(h-l+1)/2;
            //System.out.println(l+" "+mid);
            if(reach(mid)) l=mid;
            else h=mid-1;
        }
        pw.println(l);
        //System.out.println(l);
        pw.close();
        br.close();
    }
}
