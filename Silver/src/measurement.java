import java.io.*;
import java.util.*;
public class measurement {
    static class Day{
        int cow;
        int change;
        int day;
        Day(int day,int c,int d){
            this.day=day;
            cow=c;
            change=d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int days=Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        Day[] day = new Day[days];
        HashMap<Integer,Integer> cow = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<days;i++){
            st=new StringTokenizer(br.readLine());
            int dy=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            day[i]=new Day(dy,c,d);
            if(!cow.containsKey(c)){
                cow.put(c,g);
                pq.add(g);
            }
        }
        if(pq.size()==1){
            pw.println(0);
            pw.close();
            br.close();
            return;
        }
        Arrays.sort(day,(a1,a2)->a1.day-a2.day);
        int top=g;
        int pochange=0;
        for(Day e:day){
            int ccow=e.cow;
            int delta = e.change;
            if(delta==0)continue;
            //System.out.println("e.day = " + e.day);

            if(cow.get(ccow)==top){
                if(delta>0){
                    pq.remove();
                    if(pq.peek()<top){
                        pq.add(cow.get(ccow)+delta);
                        top+=delta;
                        cow.put(ccow,cow.get(ccow)+delta);
                    }else{
                        pq.add(cow.get(ccow)+delta);
                        top+=delta;
                        cow.put(ccow,cow.get(ccow)+delta);
                        pochange++;
                        //System.out.println(ccow+" "+cow.get(ccow));
                    }

                }else{
                    //System.out.println(pq.toString());
                    pq.remove();
                    //System.out.println(ccow+" "+cow.get(ccow));

                    if(cow.get(ccow)+delta>pq.peek()){
                        pq.add(cow.get(ccow)+delta);
                        top=cow.get(ccow)+delta;
                        cow.put(ccow,cow.get(ccow)+delta);
                    }else{

                        pq.add(cow.get(ccow)+delta);
                        top=pq.peek();
                        //System.out.println(pq.peek());
                        //System.out.println(pq.toString());
                        cow.put(ccow,cow.get(ccow)+delta);
                        pochange++;
                        //System.out.println(ccow+" "+cow.get(ccow));
                    }
                }
            }else{
                if(delta>0){
                    if(cow.get(ccow)+delta>=top){
                        pq.remove(cow.get(ccow));
                        pq.add(cow.get(ccow)+delta);
                        top=cow.get(ccow)+delta;
                        cow.put(ccow,cow.get(ccow)+delta);
                        pochange++;
                        //System.out.println(ccow+" "+cow.get(ccow));
                    }else{
                        //System.out.println(pq.toString());
                        pq.remove(cow.get(ccow));
                        //System.out.println(pq.toString());
                        pq.add(cow.get(ccow)+delta);
                        //System.out.println(pq.toString());
                        cow.put(ccow,cow.get(ccow)+delta);
                    }
                }else{
                    pq.remove(cow.get(ccow));
                    pq.add(cow.get(ccow)+delta);
                    cow.put(ccow,cow.get(ccow)+delta);
                }
            }
            top=Math.max(top,g);
            //System.out.println(pq.toString());
        }
        pw.println(pochange);
        //System.out.println(pochange);
        pw.close();
        br.close();
    }
}
