import java.io.*;
import java.util.*;

public class StreetLayout {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),houses=Integer.parseInt(st.nextToken()),length=Integer.parseInt(st.nextToken());
        ArrayList<Integer> f=new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            f.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(f);
        int l=1,h=length;
        while(l<h){
            int m=l+(h-l)/2;
            if(works(f,length,m)>=houses){
                h=m;
            }else{
                l=m+1;
            }
        }
        System.out.println(h);

    }
    static int works(ArrayList<Integer> f,int length,int dis){
        int tot=0;
        int last=0;
        for(int e:f){
            int h = Math.min(dis,length-e)+Math.min(dis,e-last-1);
            tot+=h;
            last = e+Math.min(dis,length-e);
        }
        return tot;
    }
}
