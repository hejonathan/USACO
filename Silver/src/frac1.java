/*
ID: 77617781
TASK: frac1
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class frac1 {
    static class fraction{
        int a,b;
        fraction(int a,int b){this.a=a;this.b=b;}
    }
    static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        TreeSet<fraction> ts=new TreeSet<>((a1,a2)-> {
            if(a1.a==a2.a&&a1.b==a2.b) return 0;
            return (double)a1.a/a1.b-(double)a2.a/a2.b > 0 ? 1:-1;
        });
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<=n;i++){
            for(int j=1;j<=n;j++){
                if((double)i/j>1) continue;
                int g=gcd(i,j);
                int ri=i/g,rj=j/g;
                ts.add(new fraction(ri,rj));
            }
        }
        for(fraction e:ts){
            pw.println(e.a+"/"+e.b);
        }
        pw.close();
        br.close();
    }
}
