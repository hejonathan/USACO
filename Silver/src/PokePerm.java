import java.io.*;
import java.util.*;

public class PokePerm {
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //System.out.println((char)('a'+1));
        int[] letters = new int[26];
        Arrays.fill(letters,0);
        for(char e:st.nextToken().toCharArray()){
            letters[e-'a']++;
        }
        int factor = 0;
        for(int rep : letters){
            factor = factor==0? rep:gcd(rep,factor);
        }
        if(factor<2){
            bw.write("IMPOSSIBLE");
            bw.close();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<letters.length;i++){
            for(int j=0;j<letters[i]/factor;j++){
                sb.append((char)('a'+i));
            }
        }
        String s = sb.toString();
        for(int i=0;i<factor;i++) bw.write(s);
        bw.close();
    }
}
