import java.io.*;
import java.util.*;

public class teleport {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
        int n=Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> ds=new TreeMap<>();
        long sum=0;
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            sum+=Math.abs(a-b);
            if(b>0&&a<0)a=0;
            if(b>a&&a>=0&&2*a<b){
                if(!ds.containsKey(2*a))ds.put(2*a,0);
                ds.put(2*a,ds.get(2*a)-1);
                if(!ds.containsKey(2*(b-a)))ds.put(2*(b-a),0);
                ds.put(2*(b-a),ds.get(2*(b-a))-1);
                if(!ds.containsKey(b))ds.put(b,0);
                ds.put(b,ds.get(b)+2);
            }
            if(b<0&&a>0)a=0;
            if(b<a&&a<=0&&2*a>b){
                if(!ds.containsKey(2*a))ds.put(2*a,0);
                ds.put(2*a,ds.get(2*a)-1);
                if(!ds.containsKey(2*(b-a)))ds.put(2*(b-a),0);
                ds.put(2*(b-a),ds.get(2*(b-a))-1);
                if(!ds.containsKey(b))ds.put(b,0);
                ds.put(b,ds.get(b)+2);
            }
        }
        Map.Entry<Integer,Integer> last=ds.pollFirstEntry();
        long mn=sum;
        int cslope= last.getValue();
        for(Map.Entry<Integer,Integer> e:ds.entrySet()){
            sum+=cslope*(e.getKey()-last.getKey());
            mn=Math.min(mn,sum);
            cslope+=e.getValue();
            last=e;
        }
        pw.println(mn);
        pw.close();
        br.close();
    }
}
