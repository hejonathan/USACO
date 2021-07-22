import java.io.*;
import java.util.*;

public class rental {
    static Integer[] cows;
    static class stores{
        int amt;
        int prc;
        stores(int a,int b){amt=a;prc=b;}
    }
    static class custore{
        long amt;
        long prc;
        custore(long a,long b){amt=a;prc=b;}
    }
    static stores[] store;
    static Integer[] rent;
    static Long[] rentsum;
    static custore[] storesum;
    static long[] cusmilk;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),r=Integer.parseInt(st.nextToken());
        cows=new Integer[n];
        store=new stores[m];
        rent=new Integer[r];
        for(int i=0;i<n;i++)cows[i]=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            store[i]=new stores(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<r;i++)rent[i]=Integer.parseInt(br.readLine());
        Arrays.sort(rent, Collections.reverseOrder());
        Arrays.sort(cows,Collections.reverseOrder());
        Arrays.sort(store,(a,b)->(b.prc-a.prc));
        rentsum=new Long[r];
        long sum=0;
        for(int i=0;i<r;i++){
            sum+=rent[i];
            rentsum[i]=sum;
        }
        sum=0;
        long mon=0;
        storesum=new custore[m];
        for(int i=0;i<m;i++){
            sum+=store[i].amt;
            mon+=store[i].amt*store[i].prc;
            storesum[i]=new custore(sum,mon);
        }
        sum=0;
        cusmilk=new long[n];
        for(int i=0;i<n;i++){
            sum+=cows[i];
            cusmilk[i]=sum;
        }
        long mx=0;
        for(int i=0;i<n;i++){
            long money=storemn(cusmilk[i])+rentmn(n-1-i);
            mx=Math.max(mx,money);
        }
        pw.println(mx);
        pw.close();
        br.close();

    }
    static long storemn(long milk){
        if(milk<storesum[0].amt)return store[0].prc*milk;
        int l=0,h=storesum.length-1;
        while(l<h){
            int m=l+(h-l+1)/2;
            if(storesum[m].amt<=milk)l=m;
            else h=m-1;
        }
        if(l<storesum.length-1)return storesum[l].prc+(milk-storesum[l].amt)*store[l+1].prc;
        else return storesum[l].prc;
    }
    static long rentmn(int cows){
        if(cows==0)return 0;
        if(cows>rentsum.length)return rentsum[rentsum.length-1];
        return rentsum[cows-1];
    }
}
