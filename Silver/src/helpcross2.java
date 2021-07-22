import java.io.*;
import java.util.*;

public class helpcross2 {
    static class pair{
        int start,end;
        pair(int a,int b){start=a;end=b;}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken()),n=Integer.parseInt(st.nextToken());
        TreeMap<Integer,Integer> chicken=new TreeMap<>();
        for(int i=0;i<c;i++){
            int t=Integer.parseInt(br.readLine());
            chicken.put(t,chicken.containsKey(t)? chicken.get(t)+1:1);
        }
        List<pair> cow=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            cow.add(new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(cow,(a1,a2)->a1.end-a2.end);
        int ans=0;
        for(pair e:cow){
            if(e.start>chicken.lastKey()) continue;
            int chi=chicken.ceilingKey(e.start);
            if(chi<=e.end){
                ans++;
                chicken.put(chi,chicken.get(chi)-1);
                if(chicken.get(chi)==0)chicken.remove(chi);
            }
        }
        pw.println(ans);
        pw.close();
        br.close();
    }
}
