import java.io.*;
import java.util.*;
public class sort {
    static int bs(List<Integer> t,int key){//how many larger than it
        if(t.size()==0)return 0;
        if(key>=t.get(t.size()-1))return t.size();
        int l=0,h=t.size()-1;
        while(l<h){
            int m=l+(h-l)/2;
            if(t.get(m)<=key)l=m+1;
            else h=m;
        }
        //System.out.println("key = " + key);
        //System.out.println("l = " + l);
        return l;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("sort.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        List<Integer> t = new ArrayList<>();
        //for each element, find how many larger than it
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int ans=bs(t,arr[i]);
            mx=Math.max(mx,t.size()-ans);
            t.add(ans,arr[i]);
            //System.out.println(t.toString());
        }
        //System.out.println(mx+1);
        pw.println(mx+1);
        pw.close();
        br.close();
    }
}
