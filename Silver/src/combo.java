/*
ID: 77617781
TASK: combo
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;

public class combo {
    static class combination {
        int a, b, c;
        combination(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            combination that = (combination) o;
            return a == that.a &&
                    b == that.b &&
                    c == that.c;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }

        @Override
        public String toString() {
            return a+" "+b+" "+c;
        }
    }
    static Set<combination> generate(int a,int b,int c){
        Set<combination> ret=new HashSet<>();
        for(int i=-2;i<=2;i++)
            for(int j=-2;j<=2;j++)
                for(int k=-2;k<=2;k++){
                    ret.add(new combination(offset(a,i),offset(b,j),offset(c,k)));
                }
        return ret;
    }
    static int offset(int a,int o){
        if(n==1) return 1;
        if(a+o>n)return a+o-n;
        if(a+o<=0)return n+a+o;
        return a+o;
    }
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("combo.in"));
        PrintWriter pw=new PrintWriter(new FileWriter("combo.out"));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken()),c=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int d=Integer.parseInt(st.nextToken()),e=Integer.parseInt(st.nextToken()),f=Integer.parseInt(st.nextToken());
        Set<combination> ans=new HashSet<>();
        ans.addAll(generate(a,b,c));
        ans.addAll(generate(d,e,f));
        System.out.println(Arrays.toString(ans.toArray()));
        pw.println(ans.size());
        pw.close();
        br.close();
    }
}
