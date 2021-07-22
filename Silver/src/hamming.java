/*
ID: 77617781
TASK: hamming
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class hamming {
    static BufferedReader br;
    static PrintWriter pw;
    static int distance(String a,String b){
        int ret=0;
        for(int i=1;Math.max(a.length(),b.length())-i>=0;i++){
            char x=(a.length()-i>=0)? a.charAt(a.length()-i):'0';
            char y=(b.length()-i>=0)? b.charAt(b.length()-i):'0';
            if(x!=y) ret++;
        }
        return ret;
    }
    static int n,b,d;
    static boolean[] vis;
    static void print(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            pw.print(arr.get(i));
            if(i%10==9||i==arr.size()-1) pw.println();
            else pw.print(" ");
        }
        //pw.println();
    }
    static class pair{
        int a,dis;
        pair(int a,int dis){this.a=a;this.dis=dis;}
    }
    static ArrayList<Integer>[] adj;
    static boolean isBetter(ArrayList<Integer> a,ArrayList<Integer> b){
        if(a.isEmpty()) return false;
        if(b.size()<n) return true;
        int suma=0,sumb=0;
        for(int e:a)suma+=e;
        for(int e:b)sumb+=e;
        return suma<sumb;
    }
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new FileReader("hamming.in"));pw = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));static PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        int max=(int) Math.pow(2,b);
        vis=new boolean[max];
        adj=new ArrayList[max];
        for(int i=0;i<max;i++) adj[i]=new ArrayList<>();
        int[][] graph=new int[max][max];
        for(int i=0;i<max-1;i++){
            for(int j=i+1;j<max;j++){
                int dis=distance(Integer.toBinaryString(i),Integer.toBinaryString(j));
                if(dis>=d){
                    adj[i].add(j);
                    adj[j].add(i);
                }
                graph[i][j]=dis;
                graph[j][i]=dis;
            }
        }
        ArrayList<Integer> s=new ArrayList<>();
        for(int i=0;i<max;i++){
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            ArrayList<Integer> current=new ArrayList<>();
            pq.add(i);
            while(!pq.isEmpty()){
                int temp=pq.remove();
                if(vis[temp]) continue;
                vis[temp]=true;
                current.add(temp);
                if(current.size()==n) break;
                for(int e:adj[temp]){
                    boolean ok=true;
                    for(int l:current){
                        if(graph[e][l]<d) ok=false;
                    }
                    if(ok && !vis[e]){
                        pq.add(e);
                        break;
                    }
                }
            }
            if(current.size()==n) {
                print(current);
                break;
            }
        }

        pw.close();
        br.close();
    }

}
