import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hps {
    static int[][][] dp;//0=H,1=P,2=S
    static int[] fj;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
        fj = new int[n+1];
        dp=new int[n+1][k+1][3];
        for(int i=0;i<dp.length;i++)for(int j=0;j<dp[i].length;j++){dp[i][j][0]=-1;dp[i][j][1]=-1;dp[i][j][2]=-1;}
        for(int i=1;i<=n;i++){
            char a=br.readLine().charAt(0);
            if(a=='H')fj[i]=0;
            else if(a=='P')fj[i]=1;
            else if(a=='S')fj[i]=2;
        }
        pw.println(Math.max(play(1,k,0),Math.max(play(1,k,1),play(1,k,2))));
        br.close();
        pw.close();
    }
    static int play(int l,int r,int state){
        if(dp[l][r][state]!=-1)return dp[l][r][state];
        if(state==fj[l]){
            dp[l][r][state]=1;
        }else{
            dp[l][r][state]=0;
        }
        if(l==dp.length-1){
            return dp[l][r][state];
        }
        if(r>0){
            dp[l][r][state]+=Math.max(play(l+1,r,state),Math.max(play(l+1,r-1,(state+1)%3),play(l+1,r-1,(state+2)%3)));
        }else{
            dp[l][r][state]+=play(l+1,r,state);
        }
        return dp[l][r][state];
    }
}
