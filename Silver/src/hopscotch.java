import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class hopscotch {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken()),c=Integer.parseInt(st.nextToken()),K=Integer.parseInt(st.nextToken());
        int[][] grid=new int[r][c];
        for(int i=0;i<r;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                grid[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        BigInteger[][] dp=new BigInteger[r][c];
        for(int i=0;i<r;i++)dp[0][i]=BigInteger.ZERO;
        for(int i=0;i<c;i++)dp[i][0]=BigInteger.ZERO;
        dp[0][0]=BigInteger.ONE;
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                BigInteger ways=BigInteger.ZERO;
                for(int k=0;k<i;k++){
                    for(int l=0;l<j;l++){
                        if(grid[k][l]!=grid[i][j])ways=ways.add(dp[k][l]);
                    }
                }
                dp[i][j]=ways;
            }
        }
        pw.println(dp[r-1][c-1].remainder(BigInteger.valueOf(1000000007)));
        pw.close();
        br.close();
    }
}
