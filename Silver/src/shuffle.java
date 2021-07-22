import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class shuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        int n=Integer.parseInt(br.readLine());
        int[] map = new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++)map[i]=Integer.parseInt(st.nextToken());
        int[] group = new int[n+1];
        Arrays.fill(group,-1);
        boolean[] good = new boolean[n+1];
        Arrays.fill(good,false);
        for(int i=1;i<=n;i++){
            //if(group[i]!=-1)continue;
            ArrayList<Integer> path = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(map[i]);
            path.add(i);
            boolean cyclefound=false;
            while(!q.isEmpty()){
                int temp= q.remove();

                if(temp==i){
                    cyclefound=true;
                    break;
                }
                if(group[temp]!=-1) {
                    cyclefound = false;
                    break;
                }
                path.add(temp);
                group[temp]=i;
                q.add(map[temp]);
            }
            if(cyclefound) {
                //System.out.println(i + " " + path.toString());
                for (int e : path) {
                    good[e] = true;
                }
            }else{
                for(int e:path){
                    group[e]=-1;
                }
            }

        }
        int ans=0;
        for(boolean e:good){
            if(e)ans++;
        }
        pw.println(ans);
        br.close();
        pw.close();
    }
}
