import java.io.*;
import java.util.*;

public class vacation {
    static class pair{
        int i,c;
        pair(int a,int b){i=a;c=b;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("vacation.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("vacation.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken()),q=Integer.parseInt(st.nextToken());
        List<pair>[] adj=new ArrayList[n+1];
        for(int i=0;i<n+1;i++)adj[i]=new ArrayList<>();
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken()),c=Integer.parseInt(st.nextToken());
            adj[a].add(new pair(b,c));
        }
        int[][] cost=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(cost[i],-1);
            PriorityQueue<pair> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a.c));
            pq.add(new pair(i,0));
            while(!pq.isEmpty()){
                pair temp=pq.remove();
                if(cost[i][temp.i]!=-1) continue;
                cost[i][temp.i]=temp.c;
                for(pair e:adj[temp.i]){
                    if(cost[i][e.i]==-1){
                        pq.add(new pair(e.i,temp.c+e.c));
                    }
                }
            }
        }
        int pos=0;
        long sum=0;
        for(int i=1;i<=q;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken()),dest=Integer.parseInt(st.nextToken());
            if(start<=k||dest<=k){
                if(cost[start][dest]!=-1) {
                    pos++;
                    sum += cost[start][dest];
                }
            }else{//if from farm to farm
                int mn=Integer.MAX_VALUE;
                for(int j=1;j<=k;j++){
                    if(cost[start][j]!=-1&&cost[j][dest]!=-1){
                        mn=Math.min(mn,cost[start][j]+cost[j][dest]);
                    }
                }
                if(mn!=Integer.MAX_VALUE){
                    pos++;
                    sum+=mn;
                }
            }
        }
        pw.println(pos);
        pw.println(sum);
        //System.out.println(pos+"\n"+sum);
        pw.close();
        br.close();
    }
}
