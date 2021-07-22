import java.io.*;
import java.util.*;

public class snowboots {
    static class boot{
        int d;
        int s;
        boot(int a,int b){s=a;d=b;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
        int[] f=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            f[i]=Integer.parseInt(st.nextToken());
        }
        Queue<boot> q=new LinkedList<>();
        for(int i=0;i<b;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),c=Integer.parseInt(st.nextToken());
            q.add(new boot(a,c));
        }
        boot shoe=q.remove();
        int l=0;
        int discard=0;
        while(l<=n){
            //scan front
            if(l+shoe.d>=n)break;
            boolean stepped=false;
            for(int i=l+shoe.d;i>l;i--){
                if(f[i]<=shoe.s){
                    l=i;
                    stepped=true;
                    break;
                }
            }
            if(!stepped){
                do{
                    discard++;
                    shoe=q.remove();
                }while(shoe.s<f[l]);
            }
        }
        //System.out.println(discard);
        pw.println(discard);
        pw.close();
        br.close();
    }
}
