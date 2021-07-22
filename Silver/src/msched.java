/*import java.io.*;
import java.util.*;

public class msched {
    static int n,m;
    static List<Integer>[] enables;
    static int[] t;
    static int[] nr;
    static int[] end;
    static class pair{
        int i,s;
        pair(int a,int b){i=a;s=b;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("msched.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("msched.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        enables=new ArrayList[n+1];
        for(int i=0;i<n+1;i++)enables[i]=new ArrayList<>();
        t=new int[n+1];
        for(int i=1;i<=n;i++){
            t[i]=Integer.parseInt(br.readLine());
        }
        nr=new int[n+1];
        Arrays.fill(nr,0);
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            enables[a].add(b);
            nr[b]++;
        }

        end=new int[n+1];
        Arrays.fill(end,-1);
        //
        /*for(int i=1;i<=n;i++){
            if(nr[i]!=0)continue;
            Queue<pair> q=new LinkedList<>();
            q.add(new pair(i,0));
            while(!q.isEmpty()){
                pair temp=q.remove();
                end[temp.i]=Math.max(end[temp.i],temp.s+t[temp.i]);
                for(int e:enables[temp.i]){
                    q.add(new pair(e,end[temp.i]));
                }
            }
        }*/
        /*PriorityQueue<pair> pq=new PriorityQueue<>((a1,a2)->{
            if(a1.s==a2.s)return t[a1.i]-t[a2.i];
            return a1.s-a2.s;
        });
        for(int i=1;i<=n;i++){
            if(nr[i]==0)pq.add(new pair(i,0));
        }
        while(!pq.isEmpty()){
            pair temp=pq.remove();
            nr[temp.i]--;
            if(nr[temp.i]>0)continue;
            if(end[temp.i]!=-1)continue;
            end[temp.i]=temp.s+t[temp.i];
            for(int e:enables[temp.i]){
                //nr[e]--;
                pq.add(new pair(e,end[temp.i]));
            }
        }
        int ans=0;
        for(int i=1;i<end.length;i++){
            ans=Math.max(ans,end[i]);
        }
        pw.println(ans);
        pw.close();
        br.close();
        //System.out.println(ans);
    }
}*/
import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class msched {
    public static int i(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("msched.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new
                FileWriter("msched.out")));
        String[] arr = in.readLine().split(" ");
        int n = i(arr[0]);
        int m = i(arr[1]);

        // input
        C = new int[n];
        for(int i=0; i<n; i++) {
            C[i] = i(in.readLine());
        }

        int[] D = new int[n];
        List<List<Integer>> E = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) E.add(new ArrayList<Integer>());
        for(int i=0; i<m; i++) {
            arr = in.readLine().split(" ");
            int x = i(arr[0])-1;
            int y = i(arr[1])-1;
            E.get(x).add(y);
            D[y]++;
        }

        // initialize queue with cows that can start immediately.
        Queue<int[]> Q = new PriorityQueue<int[]>(10,
                new Comparator<int[]>() {
                    public int compare(int[] A, int[] B) {
                        return A[1]-B[1];
                    }
                });
        for(int i=0; i<n; i++)
            if(D[i]==0) {
                Q.add(new int[]{i, C[i]});
            }

        // compute times for all cows
        int ans = 0;
        while(!Q.isEmpty()) {
            int[] e = Q.poll();
            int x = e[0];
            int t = e[1];
            ans = Math.max(ans, t);
            for(Integer y:E.get(x)) {
                D[y]--;
                if(D[y] == 0) {
                    Q.add(new int[]{y, C[y]+t});
                }
            }
        }

        out.println(ans);
        out.flush();
    }
    static int[] C;
}