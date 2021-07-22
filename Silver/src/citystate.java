import java.io.*;
import java.util.*;

public class citystate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        HashMap<String, Integer> city = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        long count = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            String s = st.nextToken();
            c = c.substring(0,2);
            String code = c+s;
            String rev = s+c;

            if(city.containsKey(rev)&&!s.equals(c)) {
                count+=city.get(rev);
                //city.put(code,city.get(rev)+1);
            }
                if(city.containsKey(code))city.put(code,city.get(code)+1);
                else city.put(code,1);
            

        }
        pw.println(count);
        pw.close();
        br.close();
    }
}
