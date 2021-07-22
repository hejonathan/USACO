/*
ID: 77617781
TASK:  skidesign
LANG: JAVA
*/
import java.io.*;
import java.util.*;
public class skidesign {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int n=Integer.parseInt(br.readLine());
        int[] h=new int[n];
        for(int i=0;i<n;i++){
            h[i]=Integer.parseInt(br.readLine());
        }
        long cost=Long.MAX_VALUE;
        for(int i=0;i+17<=100;i++){
            int min=i,max=i+17;
            long current=0;
            for(int e:h){
                if(e>max) current+=(e-max)*(e-max);
                else if(e<min) current+=(min-e)*(min-e);
            }
            cost=Math.min(current,cost);
        }
        //System.out.println(cost);
        pw.println(cost);
        pw.close();
        br.close();
    }
}
