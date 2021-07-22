import java.io.*;
import java.util.*;

public class fuel {
    static class pair{
        int x,f;
        pair(int a,int b){x=a;f=b;}
    }
    static pair[] stations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("fuel.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fuel.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),cap=Integer.parseInt(st.nextToken()),gas=Integer.parseInt(st.nextToken()),d=Integer.parseInt(st.nextToken());
        stations=new pair[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            stations[i]=new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(stations,(a1,a2)->{
            if(a1.x==a2.x)return a1.f-a2.f;
            return a1.x-a2.x;
        });
        int[] s=new int[n];
        int[] b=new int[n];
        int t1=0;
        for(int i=n-1;i>=0;i--){
            while(t1>0&&stations[s[t1-1]].f>=stations[i].f){
                t1--;
            }
            if(t1==0) b[i]=-1;
            else b[i]=s[t1-1];
            s[t1++]=i;
        }
        //System.out.println(Arrays.toString(b));
        gas-=stations[0].x;
        long ans=0;
        for(int i=0;i<n;i++){
            if(gas<0){
                pw.println(-1);pw.close();return;
            }
            int t=Math.min(cap,(b[i]==-1? d:stations[b[i]].x)-stations[i].x);
            if(t>gas){
                ans+=(long)(t-gas)*(long)stations[i].f;
                gas=t;
            }
            gas-= (i==n-1? d:stations[i+1].x)-stations[i].x;
        }
        pw.println(gas<0? -1:ans);
        pw.close();
        br.close();
    }
}

