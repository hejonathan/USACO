/*
ID: 77617781
TASK: sprime
LANG: JAVA
*/
import java.io.*;
import java.util.*;
public class sprime {
    static void solve(int n,int a,PrintWriter pw){
        if(n==N) pw.println(a);
        for(int i=1;i<=9;i++){
            if(isPrime(a*10+i))
                solve(n+1,a*10+i,pw);
        }
    }
    static boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0||n%3==0)
            return false;
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0||n%(i+2)==0)
                return false;
        }
        return true;
    }
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("sprime.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        solve(0,0,pw);
        pw.close();
        br.close();
    }
}
