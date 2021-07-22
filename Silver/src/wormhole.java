/*
ID: 77617781
TASK: wormhole
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class wormhole {
    static int n;
    static int[] x,y,pair;
    static boolean cycle(){
        int[] vis=new int[n+1];
        Arrays.fill(vis,0);
        for(int i=1;i<=n;i++){
            if(vis[i]!=0) continue;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int temp=q.poll();
                if(vis[temp]!=0) {
                    break;
                }
                vis[temp]=1;
                int nx=pair[temp];
                if(x[nx]==next.get(y[nx]).lastKey()){
                    break;
                }
                int nextAdd=next.get(y[nx]).higherEntry(x[nx]).getValue();
                if(nextAdd!=i) q.add(nextAdd);
                else{
                    //System.out.println(Arrays.toString(pair));
                    return true;
                }
            }
        }
        return false;
    }
    static int solve(){
        int ret=0;
        int i=0;
        for(i=1;i<=n;i++){
            if(pair[i]==0) break;
        }
        if(i>n) return cycle()? 1:0;
        for(int j=i+1;j<=n;j++){
            if(pair[j]==0){
                pair[i]=j;
                pair[j]=i;
                ret+=solve();
                pair[i]=0;
                pair[j]=0;
            }
        }
        return ret;
    }
    static HashMap<Integer,TreeMap<Integer,Integer>> next;//y value, set(x,index)
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter pw=new PrintWriter(new FileWriter("wormhole.out"));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        x=new int[n+1];
        y=new int[n+1];
        pair=new int[n+1];
        next=new HashMap<>();
        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            y[i]=Integer.parseInt(st.nextToken());
            pair[i]=0;
            if(!next.containsKey(y[i])) next.put(y[i],new TreeMap<>());
            next.get(y[i]).put(x[i],i);
        }
        pw.println(solve());
        pw.close();
        br.close();
    }
}
