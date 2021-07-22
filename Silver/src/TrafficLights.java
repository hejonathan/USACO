import java.io.*;
import java.util.*;

public class TrafficLights {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        TreeMap<Integer,Integer> lh=new TreeMap<>();
        TreeSet<Integer> lts=new TreeSet<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken()),l=Integer.parseInt(st.nextToken());
        lts.add(0);
        lts.add(x);
        lh.put(x-0,1);
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++){
            int p=Integer.parseInt(st.nextToken());
            int high=lts.ceiling(p),low=lts.floor(p);
            int orilen=high-low,lowlen=p-low,highlen=high-p;
            lts.add(p);

            if(lh.get(orilen)==1)lh.remove(orilen);
            else lh.put(orilen,lh.get(orilen)-1);
            lh.put(lowlen, lh.containsKey(lowlen)? lh.get(lowlen)+1:1);
            lh.put(highlen, lh.containsKey(highlen)? lh.get(highlen)+1:1);
            pw.print(lh.lastKey()+" ");
        }
        pw.close();
        br.close();
    }
}
