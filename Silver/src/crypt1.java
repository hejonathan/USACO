/*
ID: 77617781
TASK: crypt1
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class crypt1 {
    static Set<Integer> toSet(int n){
        Set<Integer> ret=new HashSet<>();
        while(n>0){
            ret.add(n%10);
            n=n/10;
        }
        return ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int n=Integer.parseInt(br.readLine());
        Set<Integer> usable=new HashSet<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            usable.add(Integer.parseInt(st.nextToken()));
        }
        int ans=0;
        Set<Integer> current;
        for(int i=100;i<=999;i++){
            for(int j=10;j<=99;j++) {
                if (i * (j % 10) > 999 || i * (j % 10) < 100 || i * (j / 10) > 999 || i * j > 9999) continue;
                current = new HashSet<>();
                current.addAll(toSet(i));
                current.addAll(toSet(j));
                current.addAll(toSet(i * (j % 10)));
                current.addAll(toSet(i * (j / 10)));
                current.addAll(toSet(i * j));
                boolean valid=true;
                for(int e:current) {
                    if (!usable.contains(e)) {
                        valid = false;
                        break;
                    }
                }
                if(valid) ans++;
            }
        }
        pw.println(ans);
        pw.close();
        br.close();
        //System.out.println(ans);
    }
}

