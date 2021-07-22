/*
ID: 77617781
TASK: milk3
LANG: JAVA
*/
import java.io.*;
import java.util.*;
public class milk3 {
    static int[] capacity;
    static class state{
        int a,b,c;
        state(int[] a){this.a=a[0];this.b=a[1];this.c=a[2];}
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            state state = (state) o;
            return a == state.a &&
                    b == state.b &&
                    c == state.c;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
    static HashSet<state> s=new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        capacity=new int[3];
        capacity[0]=Integer.parseInt(st.nextToken());
        capacity[1]=Integer.parseInt(st.nextToken());
        capacity[2]=Integer.parseInt(st.nextToken());
        solve(new int[]{0,0,capacity[2]});
        Set<Integer> ans=new TreeSet<>();
        for(state e:s){
            if(e.a==0) ans.add(e.c);
        }
        ArrayList<Integer> arr=new ArrayList<>(ans);
        for(int i=0;i<arr.size();i++){
            pw.print(arr.get(i));
            if(i!=arr.size()-1) pw.print(" ");
        }
        pw.println();
        pw.close();
        br.close();
    }
    static void solve(int[] a){
        if(s.contains(new state(a))) return;
        s.add(new state(a));
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                if(i==j||a[i]==0) continue;
                int tempi=a[i],tempj=a[j];
                if(a[i]+a[j]<=capacity[j]) {
                    a[j]+=a[i];
                    a[i]=0;
                }else{
                    a[i]=a[i]+a[j]-capacity[j];
                    a[j]=capacity[j];
                }
                solve(a);
                a[i]=tempi;
                a[j]=tempj;
            }
    }
}
