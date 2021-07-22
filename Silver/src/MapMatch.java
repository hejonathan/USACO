import java.io.*;
import java.util.*;

public class MapMatch {
    static class v{
        long x=0,y=0;
        v(long x,long y){this.x=x;this.y=y;}
    }
    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<v> m1 = new ArrayList<v>();
            ArrayList<v> m2 = new ArrayList<v>();
            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                long x = Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
                v temp = new v(x,y);
                m1.add(temp);
            }
            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
                v temp = new v(x,y);
                m2.add(temp);
            }
            Collections.sort(m1,(a1,a2)->{
                if(a1.x!=a2.x) return (int)(a1.x-a2.x);
                return (int)(a1.y-a2.y);
            });
            Collections.sort(m2,(a1,a2)->{
                if(a1.x!=a2.x) return (int)(a1.x-a2.x);
                return (int)(a1.y-a2.y);
            });
            long oX = m2.get(0).x-m1.get(0).x,oY = m2.get(0).y-m1.get(0).y;
            for(int j=0;j<m1.size();j++){
                m1.get(j).x += oX;
                m1.get(j).y += oY;
            }
            boolean works=true;
            long d1=m1.get(1).x-m1.get(0).x;
            long d2=m2.get(1).x-m2.get(0).x;
            if(d1==0||d2==0){
                d1=m1.get(1).y-m1.get(0).y;
                d2=m2.get(1).y-m2.get(0).y;
            }
            for(int j=1;j<m1.size();j++){
                if(!((m2.get(j).x-m2.get(0).x)*d1 == (m1.get(j).x-m1.get(0).x)*d2 &&
                        (m2.get(j).y-m2.get(0).y)*d1 == (m1.get(j).y-m1.get(0).y)*d2)){
                    works=false;
                    break;
                }
            }
            if(works){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        bw.close();
    }
}
