import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pails {
    static int x,y,k,m;
    static int[][][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        dp=new int[k+1][x+1][y+1];
        for(int i=0;i<dp.length;i++)for(int j=0;j<dp[i].length;j++) Arrays.fill(dp[i][j],-1);
        pw.println(operate(k,0,0));
        pw.close();
        br.close();
    }
    static int operate(int o,int a,int b){
        if(dp[o][a][b]!=-1)return dp[o][a][b];
        if(o==0)dp[o][a][b]=Math.abs(m-(a+b));
        else{
            int mn=Math.abs(m-(a+b));
            if(a>0)mn=Math.min(mn,operate(o-1,0,b));//empty either pail
            if(b>0)mn=Math.min(mn,operate(o-1,a,0));
            if(a<x)mn=Math.min(mn,operate(o-1,x,b));//fill up either pail
            if(b<y)mn=Math.min(mn,operate(o-1,a,y));
            if(a>0&&b<y){//pour one into the other
                if(a+b>=y)mn=Math.min(mn,operate(o-1,a+b-y,y));
                else mn=Math.min(mn,operate(o-1,0,a+b));
            }
            if(b>0&&a<x){
                if(a+b>=x)mn=Math.min(mn,operate(o-1,x,a+b-x));
                else mn=Math.min(mn,operate(o-1,a+b,0));
            }
            dp[o][a][b]=mn;
        }
        return dp[o][a][b];
    }
}
