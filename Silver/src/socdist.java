import java.util.*;
import java.io.*;

public class socdist {
    static class pair{
        long s,e;
        pair(long start,long end){s=start;e=end;}
    }
    static pair[] it;
    static int n;
    static boolean works(long d){
        long loc=Long.MIN_VALUE;
        long c=0;
        for(pair i:it){
            while(Math.max(loc+d,i.s)<=i.e){
                loc=Math.max(loc+d,i.s);
                c++;
                if(c>=n)break;
            }
            if(c>=n)break;
        }
        //System.out.println(c);
        return c>=n;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        it=new pair[m];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            it[i]=new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(it,(a1,a2)->a1.s<a2.s? -1:1);
        long l=1,h=(long)1e18;
        //for(int i=1;i<10;i++) System.out.println(works(i));
        //System.out.println(works(5));
        while(l<h){
            long mid=l+(h-l+1)/2;
            if(works(mid)) l=mid;
            else h=mid-1;
        }
        pw.println(h);
        //System.out.println(h);
        pw.close();
        br.close();
    }
}
