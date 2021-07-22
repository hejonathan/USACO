import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class RoomAllocation {
    static class pair{
        boolean start;
        int r,a,d;
        int order;
        pair(boolean start,int a,int b,int o){
            if(start){
                this.start=start;r=-1;this.a=a;d=b;order=o;
            }else{
                r=b;this.a=a;order=o;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        int cus=Integer.parseInt(br.readLine());
        int roomct=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((a1,a2)-> {
            if(a1.a==a2.a&&a1.start!=a2.start) return(a1.start)? -1:1;
            else return a1.a-a2.a;
        });
        for(int i=0;i<cus;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            pq.add(new pair(true,a,b,i));
        }
        Queue<Integer> av=new LinkedList<>();
        PriorityQueue<pair> or=new PriorityQueue<>((a1,a2)->a1.order-a2.order);
        while(!pq.isEmpty()){
            pair temp=pq.remove();
            if(temp.start){
                if(av.isEmpty()){
                    roomct++;
                    pq.add(new pair(false,temp.d,roomct,-1));
                    or.add(new pair(false,temp.d,roomct,temp.order));
                }else{
                    int room=av.remove();
                    pq.add(new pair(false,temp.d,room,-1));
                    or.add(new pair(false,temp.d,room,temp.order));
                }
            }else{
                av.add(temp.r);
            }
        }
        pw.println(roomct);
        while(!or.isEmpty()){
            pw.print(or.remove().r+" ");
        }
        pw.close();
        br.close();
    }

}
