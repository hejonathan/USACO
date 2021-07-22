import java.io.*;
import java.util.*;

public class p3 {
    static int numDoc,numSurvey,docPerServey;
    static Integer[] docs,sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        numDoc = Integer.parseInt(st.nextToken());
        numSurvey = Integer.parseInt(st.nextToken());
        docPerServey = Integer.parseInt(st.nextToken());
        docs = new Integer[numDoc+1];
        sum = new Integer[numDoc+1];
        for(int i=0;i<docs.length;i++){
            docs[i]=0;
            sum[i]=0;
        }
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=numDoc;i++){
            docs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(docs,1,docs.length,Collections.reverseOrder());
        for(int i=1;i<numDoc;i++){
            sum[i]=sum[i-1]+docs[i];
        }
        int r = numDoc,l=0;
        while(l<r){
            int m = l+(r-l+1)/2;
            if(works(m))
                l = m;
            else
                r = m-1;
        }
        System.out.println(r);
    }
    static boolean works(int m){
        if(numSurvey < m-docs[m]) return false;
        int numNeeded = 0;
        for(int i=1;i<=m;i++) if(docs[i]<m) numNeeded+=m-docs[i];
        if(numNeeded > numSurvey*docPerServey) return false;
        return true;
    }
}
