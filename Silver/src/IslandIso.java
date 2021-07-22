import java.io.*;
import java.util.*;

public class IslandIso {
    static class island{
        HashSet<Integer> outlet = new HashSet<>(),inlet = new HashSet<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        island[] list = new island[n+1];
        for(int i=0;i<list.length;i++) list[i]=new island();
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            list[a].outlet.add(b);
            list[b].outlet.add(a);
            list[a].inlet.add(b);
            list[b].inlet.add(a);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1,a2)->(list[a1].outlet.size()-list[a2].outlet.size()));
        for(int i=1;i<=n;i++) pq.add(i);

        while(!pq.isEmpty()){
            int temp = pq.remove();
            if(list[temp].inlet.isEmpty()) continue;

            for(int e:list[temp].inlet){
                bw.write(e+" "+temp);
                list[e].outlet.remove(e);
                pq.remove(e);
                pq.add(e);
            }

            list[temp].inlet.clear();
        }

        System.out.println();
    }
}
