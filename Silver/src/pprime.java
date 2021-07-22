/*
ID: 77617781
TASK: pprime
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class pprime {
    static boolean isPrime(int n){
        if(n<=3)
            return false;
        if(n%2==0||n%3==0)
            return false;
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0||n%(i+2)==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Set<Integer> ts=new TreeSet<>();
        int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
        for(int i=0;i<=9;i++)
            for(int j=0;j<=9;j++)
                for(int k=0;k<=9;k++)
                    for(int l=0;l<=9;l++){
                        int palindrome;
                        palindrome = i + 10*j + 100*k + 1000*l + 10000*l + 100000*k + 1000000*j + 10000000*i;
                        if(palindrome==0) continue;
                        while(palindrome%10==0) palindrome/=10;
                        if(palindrome%2!=0&&palindrome>=a&&palindrome<=b&&isPrime(palindrome)) ts.add(palindrome);
                        palindrome = i+ 10*j + 100*k + 1000*l + 10000*k + 100000*j + 1000000*i;
                        while(palindrome%10==0) palindrome/=10;
                        if(palindrome%2!=0&&palindrome>=a&&palindrome<=b&&isPrime(palindrome)) ts.add(palindrome);
                    }
        for(int e:ts) pw.println(e);
        br.close();
        pw.close();
    }
}
