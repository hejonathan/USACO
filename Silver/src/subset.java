/*
ID: 77617781
TASK: subset
LANG: JAVA
*/
import java.io.*;
import java.util.*;
public class subset {
    static int numSolutions=0,n,sum;
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("subset.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        sum=(1+n)*n/2;
        dp=new long[n+1][sum+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        if(sum%2!=0){
            pw.println(0);
            pw.close();
            br.close();
            return;
        }
        pw.println(solve(1,0)/2);
        pw.close();
        br.close();
    }
    static long solve(int number,int csum){
        if(csum==sum/2) return 1;
        if(csum>sum/2||number>n){
            return 0;
        }
        if(dp[number][csum]!=-1) return dp[number][csum];
        dp[number][csum]=0;
        dp[number][csum]+=solve(number+1,csum);
        //System.out.println(number+1+" "+csum+" "+dp[number][csum]);
        long a=solve(number+1,csum+number);
        dp[number][csum]+=a;
        //System.out.println(number+1+" "+(csum+number)+" "+a);
        return dp[number][csum];
    }

}
