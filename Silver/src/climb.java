import java.io.*;
import java.util.*;

public class climb {
    static class cow{
        int up,dn;
        cow(int a,int b){up=a;dn=b;}
    }
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("climb.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("climb.out")));
        n=Integer.parseInt(br.readLine());
        cow[] cows=new cow[n];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            cows[i]=new cow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cows, (a1,a2)->{
            if(a1.up==a2.up)return a2.dn-a1.dn;
            return a1.up-a2.up;
        });
        int[]u=new int[n];
        u[0]=cows[0].up;
        for(int i=1;i<n;i++){
            u[i]=u[i-1]+cows[i].up;
        }
        int[]d=new int[n];
        d[0]=u[0]+cows[0].dn;
        for(int i=1;i<n;i++){
            d[i]=Math.max(d[i-1],u[i])+cows[i].dn;
        }
        pw.println(d[n-1]);
        System.out.println(d[n-1]);
        pw.close();
        br.close();
    }
}
