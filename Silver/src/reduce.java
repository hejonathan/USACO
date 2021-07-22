import java.io.*;
import java.util.*;

public class reduce {
    static class po{
        int a;int b;
        po(int x,int y){a=x;b=y;}

        @Override
        public boolean equals(Object o){
            if(this.getClass()!=o.getClass())return false;
            final po p=(po)o;
            return (p==this)||(p.a==this.a&&p.b==this.b);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        int n=Integer.parseInt(br.readLine());
        TreeSet<po> x=new TreeSet<>((a1,a2)->a1.a-a2.a);
        TreeSet<po> y=new TreeSet<>((a1,a2)->a1.b-a2.b);
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            po temp=new po(a,b);
            x.add(temp);
            y.add(temp);
        }
        //1=left,2=right,3=up,4=down
        long ans=Long.MAX_VALUE;
        for(int i=1;i<=4;i++)
            for(int j=1;j<=4;j++)
                for(int k=1;k<=4;k++){
                    TreeSet<po> h=new TreeSet<>(x);
                    TreeSet<po> v=new TreeSet<>(y);
                    if(i==1)v.remove(h.pollFirst());
                    else if(i==2)v.remove(h.pollLast());
                    else if(i==3)h.remove(v.pollLast());
                    else if(i==4)h.remove(v.pollFirst());
                    if(j==1)v.remove(h.pollFirst());
                    else if(j==2)v.remove(h.pollLast());
                    else if(j==3)h.remove(v.pollLast());
                    else if(j==4)h.remove(v.pollFirst());
                    if(k==1)v.remove(h.pollFirst());
                    else if(k==2)v.remove(h.pollLast());
                    else if(k==3)h.remove(v.pollLast());
                    else if(k==4)h.remove(v.pollFirst());
                    ans=Math.min(ans,(h.last().a-h.first().a)*(v.last().b-v.first().b));
                }
        pw.println(ans);
        pw.close();
        br.close();
    }
}
