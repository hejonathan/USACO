import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class slowdown {
    static int M=1000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("slowdown.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("slowdown.out")));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Double> time = new PriorityQueue<>();
        PriorityQueue<Double> dis = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int d = Integer.parseInt(st.nextToken());
            if(t=='T')time.add((double)d);
            else dis.add((double)d);
        }
        dis.add((double)M);
        double d=0;
        double t=0;
        double slow=1;
        while(!time.isEmpty()||!dis.isEmpty()){
            boolean isdis=false;
            if(time.isEmpty()||time.peek()-t>(dis.peek()-d)*slow){
                isdis=true;
            }
            if(isdis){
                if(dis.peek()==M){
                    t+=(dis.peek()-d)*slow;
                    //System.out.println("t = " + t);
                    pw.println((int)(t+0.5));
                    //System.out.println((int)(t+0.5));
                    break;
                }
                t+=(dis.peek()-d)*slow;
                //System.out.println("t = " + t);
                d=dis.poll();
                slow+=1;
            }else{
                d+=(time.peek()-t)/slow;
                t=time.poll();
                //System.out.println("t = " + t);
                slow+=1;
            }
        }
        br.close();
        pw.close();
    }
}
