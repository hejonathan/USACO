import java.io.*;
import java.util.*;

public class diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
        int[] s=new int[n];
        for(int i=0;i<n;i++){
            s[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(s);
        int[] low=new int[n],high=new int[n];
        Arrays.fill(low,0);Arrays.fill(high,0);
        int r=0;
        for(int l=0;l<n;l++){
            while(r<n&&s[r]-s[l]<=k){// r is exclusive after the loop
                high[r]=r-l+1; // r is inclusive in the loop
                r++;
            }
            low[l]=r-l;
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(max<high[i]) max=high[i];
            else high[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            if(max<low[i]) max=low[i];
            else low[i]=max;
        }
        max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,high[i-1]+low[i]);
        }
        pw.println(max);
        //System.out.println(max);
        pw.close();
        br.close();
    }
}
