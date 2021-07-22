import java.io.*;
import java.util.*;
public class where {
    static int n;
    static char[][] g;
    static class pair{
        int l,r,u,d;
        pair(int a,int b,int c,int d){
            u=a;this.d=b;l=c;r=d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pair pair = (pair) o;
            return l == pair.l &&
                    r == pair.r &&
                    u == pair.u &&
                    d == pair.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, r, u, d);
        }
    }
    static ArrayList<pair> rec;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("where.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        n=Integer.parseInt(br.readLine());
        g=new char[n][n];
        for(int i=0;i<n;i++){
            String a=br.readLine();
            for(int j=0;j<n;j++){
                g[i][j]=a.charAt(j);
            }
        }
        rec=new ArrayList<>();
        for(int hs=1;hs<=n;hs++){
            for(int h=0;h+hs-1<n;h++){
                for(int vs=1;vs<=n;vs++){
                    for(int v=0;v+vs-1<n;v++){
                        if(check(h,h+hs,v,v+vs)){
                            rec.add(new pair(h,h+hs,v,v+vs));
                        }
                    }
                }
            }
        }
        //System.out.println(check(0,2,0,3));
        int ans=0;
        //for(pair e:rec) System.out.println(e.u+" "+e.d+" "+ e.l+" "+e.r);
        for(pair e:rec){
            boolean owned=false;
            for(pair o:rec){
                if(e.l>=o.l&&e.r<=o.r&&e.u>=o.u&&e.d<=o.d&&!e.equals(o)) owned=true;
            }
            if(!owned){
                ans++;
                System.out.println(e.u+" "+e.d+" "+ e.l+" "+e.r);
            }
        }
        pw.println(ans);
        System.out.println(ans);
        pw.close();
        br.close();
    }
    static boolean check(int up, int down, int left, int right){
        Set<Character> color=new HashSet<>();
        for(int i=up;i<down;i++)
            for(int j=left;j<right;j++){
                if(!color.contains(g[i][j]))color.add(g[i][j]);
            }
        if(color.size()!=2)return false;
        char[] spots=new char[2];
        boolean[] firstOne=new boolean[2];
        int x=0;
        for(char e:color){
            spots[x++]=e;
        }
        //System.out.println(Arrays.toString(spots));
        for(x=0;x<spots.length;x++){
            int gpcount=0;
            int[][] group=new int[n][n];
            for(int i=0;i<n;i++)Arrays.fill(group[i],0);
            for(int i=up;i<down;i++){
                for(int j=left;j<right;j++){
                    if(g[i][j]==spots[x] && group[i][j]==0)dfs(up,down,left,right,group,i,j,++gpcount);
                }
            }
            //for(int i=0;i<n;i++) System.out.println(Arrays.toString(group[i]));
            if(gpcount==1)firstOne[x]=true;
        }
        return firstOne[0]!=firstOne[1];
    }
    static void dfs(int up, int down, int left, int right,int[][]group,int i,int j,int gpcount){
        group[i][j]=gpcount;
        if(i-1>=up && g[i-1][j]==g[i][j] && group[i-1][j]==0) dfs(up,down,left,right,group,i-1,j,gpcount);
        if(i+1<down && g[i+1][j]==g[i][j] && group[i+1][j]==0) dfs(up,down,left,right,group,i+1,j,gpcount);
        if(j-1>=left && g[i][j-1]==g[i][j] && group[i][j-1]==0) dfs(up,down,left,right,group,i,j-1,gpcount);
        if(j+1<right && g[i][j+1]==g[i][j] && group[i][j+1]==0) dfs(up,down,left,right,group,i,j+1,gpcount);
    }

}
