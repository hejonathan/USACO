/*
ID: 77617781
TASK: holstein
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class holstein {
    static int[] v;
    static int[][] feed;
    static int[] taken;
    static int n,g;
    static ArrayList<combo> solutions=new ArrayList<>();
    static class combo{
        int scoop;
        TreeSet<Integer> types;
        combo(int scoop){this.scoop=scoop;types=new TreeSet<>();}
        combo(int scoop,TreeSet<Integer> ts){this.scoop=scoop;types=ts;}
        void add(int a){types.add(a);scoop++;}
        boolean isBetter(combo o){
            if(this.scoop==Integer.MAX_VALUE) return false;
            if(this.scoop<o.scoop) return true;
            int tot=0;
            for(int e:this.types) tot+=e;
            int othertot=0;
            for(int e:o.types) othertot+=e;
            return tot<othertot;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("holstein.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n=Integer.parseInt(br.readLine());
        v=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) v[i]=Integer.parseInt(st.nextToken());
        g=Integer.parseInt(br.readLine());
        feed=new int[g][n];
        taken=new int[g];
        for(int i=0;i<g;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) feed[i][j]=Integer.parseInt(st.nextToken());
        }
        solve(0,v,new ArrayList<>());
        combo best=new combo(Integer.MAX_VALUE);
        for(combo e:solutions) {
            if(!best.isBetter(e)){
                best=e;
            }
        }
        pw.print(best.scoop+" ");
        for(int e:best.types){
            pw.print(e+1);
            if(e!=best.types.last()) pw.print(" ");
        }
        pw.println();
        pw.close();
        br.close();
    }
    static void solve(int currentFeed,int[] v,ArrayList<Integer> path){
        if(currentFeed<g){
            solve(currentFeed+1,v,path);
            for(int i=0;i<v.length;i++){
                v[i]-=feed[currentFeed][i];
            }
            path.add(currentFeed);
            solve(currentFeed+1,v,path);
            for(int i=0;i<v.length;i++){
                v[i]+=feed[currentFeed][i];
            }
            path.remove(path.size()-1);
            return;
        }
        boolean pass=true;
        for(int e:v) if(e>0){
            pass=false;
            break;
        }
        if(pass) {
            TreeSet<Integer> s=new TreeSet<>(path);
            solutions.add(new combo(s.size(),s));
        }
    }
}
