import java.io.*;
import java.util.*;

public class ConcerTickets {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new FileReader(new File("test_input.txt")));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        TreeMap<Integer,Integer> ts=new TreeMap<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int t=Integer.parseInt(st.nextToken());
            ts.put(t,ts.containsKey(t)? ts.get(t)+1:1);
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int p=Integer.parseInt(st.nextToken());
            int a=(ts.isEmpty()||p<ts.firstKey())? -1:ts.floorKey(p);
            pw.println(a);
            if(a==-1)continue;
            if (ts.get(a) > 1) {
                ts.put(a, ts.get(a) - 1);
            } else {
                ts.remove(a);
            }
        }
        pw.close();
        br.close();
    }
}
