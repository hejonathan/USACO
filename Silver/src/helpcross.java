import java.io.*;
import java.util.*;

public class helpcross {
    static class event{// 1=chicken; -1=cow start; 3=cow end;
        int tp;
        int start;
        int end;
        event(int type,int start,int end){
            tp=type;
            if(type==1) this.start=start;
            else if(type==-1){
                this.start=start;
                this.end=end;
            }else{
                this.start=start;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            event event = (event) o;
            return tp == event.tp &&
                    start == event.start &&
                    end == event.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(tp, start, end);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken()),n=Integer.parseInt(st.nextToken());
        PriorityQueue<event> pq=new PriorityQueue<>((a1,a2)->{
            if(a1.start==a2.start) {
                return a1.tp-a2.tp;
            }
            return a1.start-a2.start;
        });
        for(int i=0;i<c;i++){
            pq.add(new event(1,Integer.parseInt(br.readLine()),-1));
        }
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            pq.add(new event(-1,a,b));
            pq.add(new event(3,b,-1));
        }
        int help=0;
        int ans=0;
        PriorityQueue<Integer> helpend=new PriorityQueue<>();
        while (!pq.isEmpty()) {
            event temp=pq.poll();
            if(temp.tp==-1){//start
                helpend.add(temp.end);
            }else if(temp.tp==3){//end
                helpend.remove(temp.start);
            }else if(temp.tp==1){//chicken
                if(!helpend.isEmpty()) {
                    ans++;
                    pq.remove(new event(3, helpend.remove(), -1));
                }
            }
        }
        ans=Math.min(ans,Math.min(c,n));
        pw.println(ans);
        //System.out.println(ans);
        pw.close();
        br.close();
    }
}
