import java.io.*;
import java.util.*;

public class bcount {
    static int bs(List<Integer> a, int t){
        if(a.size()==0)return 0;
        if(t<a.get(0))return -1;
        int h=a.size()-1,l=0;
        while(l<h){
            int m=l+(h-l+1)/2;
            if(a.get(m)<=t)l=m;
            else h=m-1;
        }
        return l;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),q=Integer.parseInt(st.nextToken());
        List<Integer> cow1 = new ArrayList<>();
        List<Integer> cow2 = new ArrayList<>();
        List<Integer> cow3 = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp==1)cow1.add(i);
            if(temp==2)cow2.add(i);
            if(temp==3)cow3.add(i);
        }
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int lower=Integer.parseInt(st.nextToken()),upper=Integer.parseInt(st.nextToken());
            pw.print(bs(cow1,upper)-bs(cow1,lower-1)+" ");
            pw.print(bs(cow2,upper)-bs(cow2,lower-1)+" ");
            //int a=bs(cow3,upper),b=bs(cow3,lower-1);
            pw.println(bs(cow3,upper)-bs(cow3,lower-1));
            //System.out.println(a+" "+b);
        }
        pw.close();
        br.close();
    }
}
