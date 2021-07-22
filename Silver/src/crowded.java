import java.io.*;
import java.util.*;

public class crowded {
    static class pair{
        int x,h;
        pair(int a,int b){x=a;h=b;}
    }

    static int n;
    static pair[] cow;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("crowded.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crowded.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        cow=new pair[n];
        int ans=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            cow[i]=new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cow,(a1,a2)->a1.x-a2.x);
        int front=0,back=-1;
        Queue<pair> pq=new PriorityQueue<>((a1,a2)->a2.h-a1.h);
        boolean[] rg=new boolean[n];
        boolean[] lg=new boolean[n];
        while(front<n && back<n-1){
            while(front<n && cow[front].x<=cow[back+1].x+d){//front extend
                if(!pq.isEmpty() && pq.peek().h>=2*cow[front].h) lg[front]=true;
                pq.add(cow[front++]);
            }
            while(back<front && front<n && cow[front].x>cow[back+1].x+d){//back retract
                if(!pq.isEmpty() && back>=0 && pq.peek().h>=2*cow[back].h) rg[back]=true;
                pq.remove(cow[back+1]);
                back++;
            }
        }
        while(back<n-1){//back retract
            if(!pq.isEmpty() && back>=0 && pq.peek().h>=2*cow[back].h) rg[back]=true;
            pq.remove(cow[back+1]);
            back++;
        }


        /*int cur=0,right=1;
        PriorityQueue<Integer> h=new PriorityQueue<>(Collections.reverseOrder());
        boolean[] rg=new boolean[n];
        boolean[] lg=new boolean[n];
        while(cur<n){
            while(right<n&&cow[right].x-cow[cur].x<=d){
                if(right!=cur)h.add(cow[right].h);
                right++;
            }
            if(!h.isEmpty()&&h.peek()>=cow[cur].h*2)rg[cur]=true;
            if(!h.isEmpty())h.remove(cow[++cur].h);
            else cur++;
        }
        cur=n-1;
        int left=n-2;
        h=new PriorityQueue<>(Collections.reverseOrder());
        while(cur>=0){
            while(left>=0&&cow[cur].x-cow[left].x<=d){
                if(cur!=left)h.add(cow[left].h);
                left--;
            }
            if(!h.isEmpty()&&h.peek()>=cow[cur].h*2)lg[cur]=true;
            if(!h.isEmpty())h.remove(cow[--cur].h);
            else cur--;
        }*/
        //System.out.println(Arrays.toString(rg));
        //System.out.println(Arrays.toString(lg));
        for(int i=0;i<rg.length;i++){
            if(rg[i]&&lg[i])ans++;
        }
        pw.println(ans);
        pw.close();
        //System.out.println(ans);
        br.close();
    }
}
